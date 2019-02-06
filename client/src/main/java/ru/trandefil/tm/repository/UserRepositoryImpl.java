package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private static Map<String, User> userMap = new HashMap<>();

    @Override
    public void clear() {
        userMap.clear();
    }

    @Override
    public User delete(User user) {
        return deleteByName(user.getName());
    }

    @Override
    public User deleteByName(String name) {
        return userMap.remove(name);
    }

    @Override
    public User save(User user) {
        return userMap.put(user.getName(), user);
    }

    @Override
    public User getByName(String userName) {
        return userMap.get(userName);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getLoginUser(String userName, String userPassword) {
        return userMap.get(userName);
    }

}
