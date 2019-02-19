package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.SessionService;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.HashUtil;
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
    public User delete(@NonNull User user) {
        return userRepository.delete(user);
    }

    @Override
    public User deleteByName(@NonNull String name) {
        return userRepository.deleteByName(name);
    }

    @Override
    public User save(@NonNull User user) {
        if(user.isNew()){
            user.setId(UUIDUtil.getUniqueString());
            return userRepository.save(user);
        }
        return userRepository.update(user);
    }

    @Override
    public User getByName(@NonNull String userName) {
        return userRepository.getByName(userName);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public Session getSession(@NonNull String userName, @NonNull String userPassword) {
        User user = userRepository.getLoginUser(userName, HashUtil.hashPassword(userPassword));
        if (user == null) {
            System.out.println("bad login.");
            return null;
        }
        System.out.println("logged " + user.getName());
        Session newSess = createNewSession(user.getId(), user.getRole());
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
        if("ADMIN".equals(role) || "USER".equals(role)){
            Role newRole = Enum.valueOf(Role.class, role);
            User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            return save(newUser);
        }
        System.out.println("bad user role.");
        return null;
    }

}
