package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserService {

    void delete(User user);

    void deleteByName(String name);

    User save(User user);

    User getByName(String userName);

    List<User> getAll();

    Session getSession(String userName, String userPassword);

    void logout(String sessionId);

    User constractUser(String name, String pass, String role);

}
