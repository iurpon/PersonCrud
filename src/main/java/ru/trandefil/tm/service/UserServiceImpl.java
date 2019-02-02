package ru.trandefil.tm.service;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.repository.UserRepository;

public class UserServiceImpl implements UserSevice {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public User deleteByName(String name) {
        return userRepository.deleteByName(name);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByName(String userName) {
        return userRepository.getByName(userName);
    }
}
