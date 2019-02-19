package ru.trandefil.tm.repository;

import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.mappers.UserMapper;

import java.util.List;
import java.util.logging.Logger;

public class UserMBRepositoryImpl implements UserRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private SqlSessionService sqlSessionService;

    public UserMBRepositoryImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public User delete(User user) {
/*        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.getById(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;*/
        return null;
    }

    @Override
    public User deleteByName(String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getByName(name);
        if (user == null) {
            logger.info("wrong deleting name.");
            return null;
        }
        userMapper.deleteById(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User save(User user) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User getByName(String userName) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getByName(userName);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User update(User user) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.update(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public List<User> getAll() {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getAll();
        sqlSessionService.closeSqlSession(sqlSession);
        return users;
    }

    @Override
    public User getLoginUser(String userName, String userPassword) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getByNameAndPass(userName, userPassword);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public void clear() {

    }

    @Override
    public User getById(String id) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getById(id);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

}
