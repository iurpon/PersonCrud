package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll(Session session);

    Task save(Task task, Session session);

    Task delete(Task task, Session session);

    Task deleteByName(String name, Session session);

    Task getByName(String name, Session session);

}
