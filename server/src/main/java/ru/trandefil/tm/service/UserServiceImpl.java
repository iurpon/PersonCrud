package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.SessionService;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private SessionService sessionService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private SqlSessionService sqlSessionService;

    public UserServiceImpl(SessionService sessionService, SqlSessionService sqlSessionService) {
        this.sessionService = sessionService;
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public User delete(@NonNull User user) {
        return null;
    }

    @Override
    public User deleteByName(@NonNull String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user = userRepository.getByName(name);
        if (user == null) {
            logger.info("wrong deleting name.");
            return null;
        }
        userRepository.deleteById(user);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public User save(@NonNull User user) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
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
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user = userRepository.getByName(userName);
        sqlSessionService.closeSqlSession(sqlSession);
        return user;
    }

    @Override
    public List<User> getAll() {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        List<User> users = userRepository.getAll();
        sqlSessionService.closeSqlSession(sqlSession);
        return users;
    }

    @Override
    public Session getSession(@NonNull String userName, @NonNull String userPassword) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user = userRepository.getByNameAndPass(userName, HashUtil.hashPassword(userPassword));
        if (user == null) {
            System.out.println("bad login.");
            sqlSessionService.closeSqlSession(sqlSession);
            return null;
        }
        System.out.println("logged " + user.getName());
        Session newSess = createNewSession(user.getId(), user.getRole());
        sqlSessionService.closeSqlSession(sqlSession);
        return newSess;
    }

    private Session createNewSession(@NonNull String userId, @NonNull Role role) {
        String uuid = UUIDUtil.getUniqueString();
        long timeStamp = System.nanoTime();
        String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        Session created = new Session(uuid, timeStamp, userId, role, signature);
        sessionService.saveSession(created);
        return created;
    }

    @Override
    public void logout(@NonNull String sessionId) {
        sessionService.deleteSession(sessionId);
    }

    @Override
    public User constractUser(@NonNull String name, @NonNull String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            Role newRole = Enum.valueOf(Role.class, role);
            User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            return save(newUser);
        }
        System.out.println("bad user role.");
        return null;
    }

}
