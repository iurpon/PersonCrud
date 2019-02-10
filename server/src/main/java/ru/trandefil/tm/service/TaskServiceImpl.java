package ru.trandefil.tm.service;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(Session session) {
        return new ArrayList(taskRepository.getAll());
    }

    public Task save(Task task, Session session) {
        return taskRepository.save(task);
    }

    public Task delete(Task task, Session session) {
        return taskRepository.delete(task);
    }

    public Task deleteByName(String name, Session session) {
        return taskRepository.deleteByName(name);
    }

    public Task getByName(String name, Session session) {
        return taskRepository.getByName(name);
    }

}
