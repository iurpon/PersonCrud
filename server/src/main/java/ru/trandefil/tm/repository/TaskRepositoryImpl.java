package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepositoryImpl implements TaskRepository {

    private Map<String, Task> tasks = new ConcurrentHashMap<>();

    @Override
    public Task save(final Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void clear() {
        tasks.clear();
    }

    @Override
    public Task delete(String userId, Task task) {
        return tasks.remove(task.getId());
    }

    @Override
    public Task deleteByName(String userId, String name) {
        Task removing = getAll(userId).stream()
                .filter(t -> t.getName().equals(name))
                .findAny()
                .orElse(null);
        return removing;
    }

    @Override
    public List<Task> getAll(String userId) {
        return new ArrayList(tasks.values());
    }

    @Override
    public Task getByName(String userId, String name) {
        Task byName = getAll(userId).stream()
                .filter(t -> t.getName().equals(name))
                .findAny()
                .orElse(null);
        return byName;
    }

    @Override
    public Task getByid(String userId,String id) {
        return tasks.get(id);
    }

//    @Override
    public Task update(String userId,Task task) {
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }
}
