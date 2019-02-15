package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll(String userId);

    Task save(Task task);

    Task delete(String userId, Task task);

    Task deleteByName(String userId, String name);

    Task getByName(String userId, String name);

    List<Task> getAll();

}
