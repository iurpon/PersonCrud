package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepository {
    public static Map<String, Task> tasks = new ConcurrentHashMap<>();

}
