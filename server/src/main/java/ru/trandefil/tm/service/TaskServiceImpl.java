package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.mappers.TaskMapper;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;

public class TaskServiceImpl implements TaskService {

    private SqlSessionService sqlSessionService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public TaskServiceImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    public List<Task> getAll(@NonNull String userId) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        List<Task> tasks = taskMapper.getAllFiltered(userId);
        sqlSessionService.closeSqlSession(sqlSession);
        return tasks;
    }

    public Task save(@NonNull String userId, @NonNull Task task) {
        if (!userId.equals(task.getAssigneeId())) {
            return null;
        }
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        if (task.isNew()) {
            task.setId(UUIDUtil.getUniqueString());
            taskMapper.insert(task);
            sqlSessionService.closeSqlSession(sqlSession);
            return task;
        }
        taskMapper.update(task);
        sqlSessionService.closeSqlSession(sqlSession);
        return task;
    }

    public Task delete(@NonNull String userId, @NonNull Task task) {
        return null;
    }

    public Task deleteByName(@NonNull String userId, @NonNull String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        Task removing = taskMapper.getByName(userId, name);
        if (removing == null) {
            System.out.println("wrong task name.");
            return null;
        }
        taskMapper.deleteById(removing);
        sqlSessionService.closeSqlSession(sqlSession);
        return removing;
    }

    public Task getByName(@NonNull String userId, @NonNull String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        Task task = taskMapper.getByName(userId, name);
        sqlSessionService.closeSqlSession(sqlSession);
        return task;
    }

    @Override
    public Task getByid(@NonNull String userId, @NonNull String id) {
        return null;
    }
}
