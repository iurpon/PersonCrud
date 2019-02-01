package ru.trandefil.tm.service;

import ru.trandefil.tm.repository.AbstractRepository;
import ru.trandefil.tm.repository.TaskRepository;

import java.util.List;

public class TaskService implements AbstractService {
    private AbstractRepository taskRepository;

    public TaskService(AbstractRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskService> getAll() {
        return null;
    }
}
