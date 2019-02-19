package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(@NonNull String userId) {
        return taskRepository.getAll(userId);
    }

    public Task save(@NonNull String userId, @NonNull Task task) {
        if (!userId.equals(task.getAssigneeId())) {
            return null;
        }
        if (task.isNew()) {
            task.setId(UUIDUtil.getUniqueString());
            return taskRepository.save(task);
        }
        return taskRepository.update(task);
    }

    public Task delete(@NonNull String userId, @NonNull Task task) {
        return taskRepository.delete(userId, task);
    }

    public Task deleteByName(@NonNull String userId, @NonNull String name) {
        return taskRepository.deleteByName(userId, name);
    }

    public Task getByName(@NonNull String userId, @NonNull String name) {
        return taskRepository.getByName(userId, name);
    }

    @Override
    public Task getByid(@NonNull String userId, @NonNull String id) {
        return taskRepository.getByid(userId, id);
    }
}
