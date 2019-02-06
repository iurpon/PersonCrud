package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepositoryImpl implements TaskRepository {

    public Map<String, Task> tasks = new ConcurrentHashMap<>();

    public Task save(final Task task) {
        tasks.put(task.getName(), task);
        return task;
    }

    @Override
    public void clear() {
        tasks.clear();
    }

    public Task delete(final Task task) {
        return tasks.remove(task.getName());
    }

    public Task deleteByName(final String name) {
        return tasks.remove(name);
    }

    public List<Task> getAll() {
        return new ArrayList(tasks.values());
    }

    public Task getByName(final String name) {
        return tasks.get(name);
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

}
