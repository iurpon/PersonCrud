package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Task;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRepository implements AbstractRepository {
    public Map<String, Task> tasks = new ConcurrentHashMap<>();

    public Task save(Task task){
        tasks.put(task.getName(),task);
        return task;
    }

    public Task delete(Task task){
        return tasks.remove(task.getName());
    }

    public Task deleteByName(String name){
        return tasks.remove(name);
    }

    public Collection<Task> getAll(){
        return tasks.values();
    }

    public Task getByName(String name){
        return tasks.get(name);
    }

}
