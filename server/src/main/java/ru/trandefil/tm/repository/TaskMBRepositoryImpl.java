package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;

import java.util.List;
import java.util.logging.Logger;

public class TaskMBRepositoryImpl implements TaskRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private SqlSessionService sqlSessionService;

    public TaskMBRepositoryImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public List<Task> getAll(String userId) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public Task delete(String userId, Task task) {
        return null;
    }

    @Override
    public Task deleteByName(String userId, String name) {
        return null;
    }

    @Override
    public Task getByName(String userId, String name) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Task getByid(String userId, String id) {
        return null;
    }

    @Override
    public Task update(String userId, Task task) {
        return null;
    }
}
