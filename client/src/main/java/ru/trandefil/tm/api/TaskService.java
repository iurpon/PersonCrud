package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task save(Task task);

    Task delete(Task task);

    Task deleteByName(String name);

    Task getByName(String name);

}
