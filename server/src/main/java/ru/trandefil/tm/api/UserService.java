package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserService {

    User delete(User user, Session session);

    User deleteByName(String name,Session session);

    User save(User user,Session session);

    User getByName(String userName,Session session);

    List<User> getAll(Session session);

    Session getSession(String userName, String userPassword);

}
