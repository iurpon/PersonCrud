package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepository implements AbstractRepository {
    public Map<String, Task> tasks = new ConcurrentHashMap<>();

}
