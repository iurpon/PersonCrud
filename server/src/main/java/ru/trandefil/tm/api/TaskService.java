package ru.trandefil.tm.api;

 import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll(String userId);

    Task save(Task task);

    Task delete(Task task, String userId);

    Task deleteByName(String name, String userId);

    Task getByName(String name, String userId);

}
