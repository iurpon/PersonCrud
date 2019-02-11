package ru.trandefil.tm.service;

import ru.trandefil.tm.api.SessionRepository;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private SessionRepository sessionRepository;

    public UserServiceImpl(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public User delete(User user, Session session) {
        return userRepository.delete(user);
    }

    @Override
    public User deleteByName(String name, Session session) {
        return userRepository.deleteByName(name);
    }

    @Override
    public User save(User user, Session session) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String userName, Session session) {
        return userRepository.getByName(userName);
    }

    @Override
    public List<User> getAll(Session session) {
        return userRepository.getAll();
    }

    @Override
    public Session getSession(String userName, String userPassword) {
        User user = userRepository.getLoginUser(userName, userPassword);
        if (user == null) {
            return null;
        }
        Session newSess = createNewSession(user.getId());
        return newSess;
    }

    private Session createNewSession(String userId) {
        String uuid = UUIDUtil.getUniqueString();
        long timeStamp = System.nanoTime();
        String signature = SignatureUtil.createSignature(uuid, userId, timeStamp);
        Session created = new Session(uuid, timeStamp, userId, signature);
        sessionRepository.save(created);
        return created;
    }

}
