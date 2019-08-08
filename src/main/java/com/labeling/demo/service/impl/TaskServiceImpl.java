package com.labeling.demo.service.impl;

import com.labeling.demo.entity.Task;
import com.labeling.demo.repository.TaskMapper;
import com.labeling.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Task task) {
        taskMapper.insertSelective(task);
    }

    @Override
    public List<Task> findAll() {
        return taskMapper.findAll();
    }

    @Override
    public Task findByName(String taskName) {
        return taskMapper.selectByPrimaryKey(taskName);
    }
}