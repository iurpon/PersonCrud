package ru.trandefil.tm.service;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll(String userId) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task save(String userId, Task task) {
        return null;
    }

    @Override
    public Task delete(String userId, Task task) {
        return null;
    }

    @Override
    public Task deleteByName(String userId, String name) {
        return null;
    }

    @Override
    public Task getByName(String userId, String name) {
        return null;
    }

    @Override
    public Task getByid(String userId, String id) {
        return null;
    }
}
