package ru.trandefil.tm.service;

import ru.trandefil.tm.entity.Task;

import ru.trandefil.tm.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService{
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return new ArrayList(taskRepository.getAll());
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task delete(Task task){
        return taskRepository.delete(task);
    }

    public Task deleteByName(String name){
        return taskRepository.deleteByName(name);
    }

    public Task getByName(String name){
        return taskRepository.getByName(name);
    }

}
