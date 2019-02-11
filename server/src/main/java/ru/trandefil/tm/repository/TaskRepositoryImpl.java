package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepositoryImpl implements TaskRepository {

    private Map<String, Task> tasks = new ConcurrentHashMap<>();

    public Task save(final Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void clear() {
        tasks.clear();
    }

    public Task delete(final Task task) {
        return tasks.remove(task.getId());
    }

    public Task deleteByName(final String name) {
        Task removing = getAll().stream()
                .filter(t -> t.getName().equals(name))
                .findAny()
                .orElse(null);
        return tasks.remove(removing.getId());
    }

    public List<Task> getAll() {
        return new ArrayList(tasks.values());
    }

    public Task getByName(final String name) {
        Task byName = getAll().stream()
                .filter(t -> t.getName().equals(name))
                .findAny()
                .orElse(null);
        return byName;
    }

    @Override
    public Task getByid(String id) {
        return tasks.get(id);
    }
}
