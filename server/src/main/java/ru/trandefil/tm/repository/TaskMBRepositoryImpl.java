package ru.trandefil.tm.repository;

import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.mappers.TaskMapper;

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
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        List<Task> tasks = taskMapper.getAllFiltered(userId);
        sqlSessionService.closeSqlSession(sqlSession);
        return tasks;
    }

    @Override
    public Task save(Task task) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        taskMapper.insert(task);
        sqlSessionService.closeSqlSession(sqlSession);
        return task;
    }

    @Override
    public Task delete(String userId, Task task) {
/*        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);

        sqlSessionService.closeSqlSession(sqlSession);*/
        return null;
    }

    @Override
    public Task deleteByName(String userId, String name) {
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

    @Override
    public Task getByName(String userId, String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        Task task = taskMapper.getByName(userId, name);
        sqlSessionService.closeSqlSession(sqlSession);
        return task;
    }

    @Override
    public void clear() {

    }

    @Override
    public Task getByid(String userId, String id) {
        return null;
    }

    @Override
    public Task update(Task task) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        TaskMapper taskMapper = sqlSession.getMapper(TaskMapper.class);
        taskMapper.update(task);
        sqlSessionService.closeSqlSession(sqlSession);
        return task;
    }

}
