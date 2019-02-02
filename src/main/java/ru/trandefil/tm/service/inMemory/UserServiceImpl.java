package ru.trandefil.tm.service.inMemory;

import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.repository.UserRepository;
import ru.trandefil.tm.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
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

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getLoginUser(String userName, String userPassword) {
        User user = userRepository.getLoginUser(userName, userPassword);
        if (user == null) {
            return null;
        }
        return userPassword.equals(user.getPassword()) ? user : null;
    }
}
