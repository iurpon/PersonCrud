package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private Map<String, User> userMap = new HashMap<>();

/*        public static final User USER = new User(UUIDUtil.getUniqueString(), "User", "userPassword", Role.USER);//userPassword

        public static final User ADMIN = new User(UUIDUtil.getUniqueString(), "Admin", "adminPassword", Role.ADMIN);//adminPassword

        {
            userMap.put(USER.getId(), USER);
            userMap.put(ADMIN.getId(), ADMIN);
        }
    {
        initFromJson();
    }

    private void initFromJson() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonString = new String(Files.readAllBytes(Paths.get("data.json")));
            final Domain command = objectMapper.readValue(jsonString, Domain.class);
            command.getUsers().forEach(this::save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void clear() {
        userMap.clear();
    }

    @Override
    public User delete(User user) {
        return userMap.remove(user.getId());
    }

    @Override
    public User deleteByName(String name) {
        User user = getByName(name);
        if (user == null) {
            System.out.println("User deleteByName null");
            return null;
        }
        System.out.println("deleting " + user);
        return userMap.remove(user.getId());
    }

    @Override
    public User save(User user) {
        return userMap.put(user.getId(), user);
    }

    @Override
    public User getByName(String userName) {
        User user = getAll().stream()
                .filter(u -> u.getName().equals(userName))
                .findAny()
                .orElse(null);
        if (user == null) {
            System.out.println("User getByName null");
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getLoginUser(String userName, String userPassword) {
        return getAll().stream()
                .filter(u -> u.getName().equals(userName))
                .findAny()
                .orElse(null);
    }

    @Override
    public User getById(String id) {
        return userMap.get(id);
    }

}
