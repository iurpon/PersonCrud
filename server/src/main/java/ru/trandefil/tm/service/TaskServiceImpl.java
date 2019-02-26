package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;

import javax.management.Query;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll(@NonNull String userId) {
//        Query query =
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task save(@NonNull String userId,@NonNull Task task) {
        return null;
    }

    @Override
    public Task delete(@NonNull String userId, @NonNull Task task) {
        return null;
    }

    @Override
    public Task deleteByName(@NonNull String userId, @NonNull String name) {
        return null;
    }

    @Override
    public Task getByName(@NonNull String userId, @NonNull String name) {
        return null;
    }

    @Override
    public Task getByid(@NonNull String userId, @NonNull String id) {
        return null;
    }

}
