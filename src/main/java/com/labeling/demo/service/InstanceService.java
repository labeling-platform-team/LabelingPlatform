package com.labeling.demo.service;

import com.labeling.demo.entity.Instance;

import java.util.List;

public interface InstanceService {
    void save(Instance instance);

    void saveAll(Iterable<Instance> instances);

    List<Instance> findAll();

    List<Instance> findByTaskName(String taskName);
}