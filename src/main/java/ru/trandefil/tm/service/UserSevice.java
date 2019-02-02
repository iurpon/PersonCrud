package ru.trandefil.tm.service;

import ru.trandefil.tm.entity.User;

public interface UserSevice {
    User delete(User user);

    User deleteByName(String name);

    User save(User user);

    User getByName(String userName);
}
