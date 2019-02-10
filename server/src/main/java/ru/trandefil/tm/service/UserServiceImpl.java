package ru.trandefil.tm.service;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User delete(User user, Session session) {
        return userRepository.delete(user);
    }

    @Override
    public User deleteByName(String name,Session session) {
        return userRepository.deleteByName(name);
    }

    @Override
    public User save(User user,Session session) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String userName,Session session) {
        return userRepository.getByName(userName);
    }

    @Override
    public List<User> getAll(Session session) {
        return userRepository.getAll();
    }

    @Override
    public User getLoginUser(String userName, String userPassword,Session session) {
        User user = userRepository.getLoginUser(userName, userPassword);
        if (user == null) {
            return null;
        }
        return userPassword.equals(user.getPassword()) ? user : null;
    }

}
