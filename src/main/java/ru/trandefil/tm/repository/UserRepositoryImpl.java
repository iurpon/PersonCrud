package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    public static final User USER = new User(UUIDUtil.getUniqueString(), "User", "221068207E125B97BEB4E2D062E888B1");//userPassword

    public static final User ADMIN = new User(UUIDUtil.getUniqueString(), "Admin", "33D87FD364516F6604124FCC76FDD279");//adminPassword

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("Admin",ADMIN);
        userMap.put("User",USER);
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
