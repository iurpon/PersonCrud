package ru.trandefil.tm.service;

import ru.trandefil.tm.api.SessionService;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private SessionService sessionService;

    public UserServiceImpl(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

    @Override
    public User delete(User user, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userRepository.delete(user);
    }

    @Override
    public User deleteByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userRepository.deleteByName(name);
    }

    @Override
    public User save(User user, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User getByName(String userName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
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
            System.out.println("bad login.");
            return null;
        }
        System.out.println("logged " + user.getName());
        Session newSess = createNewSession(user.getId(), user.getRole());
        return newSess;
    }

    private Session createNewSession(String userId, Role role) {
        String uuid = UUIDUtil.getUniqueString();
        long timeStamp = System.nanoTime();
        String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        Session created = new Session(uuid, timeStamp, userId, role, signature);
        sessionService.saveSession(created);
        return created;
    }

}
