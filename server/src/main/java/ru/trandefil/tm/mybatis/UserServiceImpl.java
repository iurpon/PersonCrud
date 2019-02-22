package ru.trandefil.tm.mybatis;

import lombok.NonNull;
import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.*;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.mybatis.SessionRepository;
import ru.trandefil.tm.mybatis.UserRepository;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private SqlSessionService sqlSessionService;

    public UserServiceImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public void delete(@NonNull User user) {

    }

    @Override
    public boolean deleteByName(@NonNull String name) {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        final User user = userRepository.getByName(name);
        if (user == null) {
            logger.info("wrong deleting name.");
            return false;
        }
        userRepository.deleteById(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user != null;
    }

    @Override
    public User save(@NonNull User user) {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        if (user.isNew()) {
            user.setId(UUIDUtil.getUniqueString());
            userRepository.insert(user);
            sqlSessionService.closeSqlSession(sqlSession);
            return user;
        }
        userRepository.update(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User getByName(@NonNull String userName) {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        final User user = userRepository.getByName(userName);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public List<User> getAll() {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        final List<User> users = userRepository.getAll();
        sqlSessionService.closeSqlSession(sqlSession);
        return users;
    }

    @Override
    public Session getSession(@NonNull String userName, @NonNull String userPassword) {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        final User user = userRepository.getByNameAndPass(userName, HashUtil.hashPassword(userPassword));
        if (user == null) {
            System.out.println("bad login.");
            sqlSessionService.closeSqlSession(sqlSession);
            return null;
        }
        System.out.println("logged " + user.getName());
        final Session newSess = createNewSession(user.getId(), user.getRole());
        SessionRepository mapper = sqlSession.getMapper(SessionRepository.class);
        mapper.insert(newSess);
        sqlSessionService.closeSqlSession(sqlSession);
        return newSess;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role) {
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        return created;
    }

    @Override
    public void logout(@NonNull final String sessionId) {
        final SqlSession sqlSession = sqlSessionService.getSqlSession();
        final SessionRepository mapper = sqlSession.getMapper(SessionRepository.class);
        mapper.deleteById(sessionId);
        sqlSessionService.closeSqlSession(sqlSession);
    }

    @Override
    public User constractUser(@NonNull final String name, @NonNull final String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            final Role newRole = Enum.valueOf(Role.class, role);
            final User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            return save(newUser);
        }
        System.out.println("bad user role.");
        return null;
    }

}
