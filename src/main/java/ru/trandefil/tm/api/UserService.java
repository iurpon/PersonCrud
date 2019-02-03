package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.User;
import java.util.List;

public interface UserService {

    User delete(User user);

    User deleteByName(String name);

    User save(User user);

    User getByName(String userName);

    List<User> getAll();

    User getLoginUser(String userName, String userPassword);
}
