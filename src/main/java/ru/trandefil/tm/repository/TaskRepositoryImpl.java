package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.trandefil.tm.repository.ProjectRepositoryImpl.*;
import static ru.trandefil.tm.repository.UserRepositoryImpl.*;

public class TaskRepositoryImpl implements TaskRepository {

    public static final Task TASK1 = new Task(UUIDUtil.getUniqueString(), "TASK1", "TASK1DESC1", null, null, PROJECT1, ADMIN, ADMIN);

    public static final Task TASK2 = new Task(UUIDUtil.getUniqueString(), "TASK2", "TASK1DESC2", null, null, PROJECT1, ADMIN, USER);

    public static final Task TASK3 = new Task(UUIDUtil.getUniqueString(), "TASK3", "TASK1DESC3", null, null, PROJECT1, USER, USER);

    public Map<String, Task> tasks = new ConcurrentHashMap<>();

    {
        tasks.put(TASK1.getName(),TASK1);
        tasks.put(TASK2.getName(),TASK2);
        tasks.put(TASK3.getName(),TASK3);
    }

    public Task save(Task task) {
        tasks.put(task.getName(), task);
        return task;
    }

    public Task delete(Task task) {
        return tasks.remove(task.getName());
    }

    public Task deleteByName(String name) {
        return tasks.remove(name);
    }

    public List<Task> getAll() {
        return new ArrayList(tasks.values());
    }

    public Task getByName(String name) {
        return tasks.get(name);
    }

}
