package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepositoryImpl implements TaskRepository {

    private Map<String, Task> tasks = new ConcurrentHashMap<>();

/*    public static final Task TASK1 = new Task(UUIDUtil.getUniqueString(),
            "TASK1", "TASK1DESC1", null, null, PROJECT1.getId(), ADMIN.getId(), ADMIN.getId());

    public static final Task TASK2 = new Task(UUIDUtil.getUniqueString(),
            "TASK2", "TASK1DESC2", null, null, PROJECT1.getId(), ADMIN.getId(), USER.getId());

    public static final Task TASK3 = new Task(UUIDUtil.getUniqueString(),
            "TASK3", "TASK1DESC3", null, null, PROJECT3.getId(), USER.getId(), USER.getId());

    {
        tasks.put(TASK1.getId(),TASK1);
        tasks.put(TASK2.getId(),TASK2);
        tasks.put(TASK3.getId(),TASK3);
    }*/


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
        return removing;
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
