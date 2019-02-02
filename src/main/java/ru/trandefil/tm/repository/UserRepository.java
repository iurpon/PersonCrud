package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.User;

public interface UserRepository {


    User delete(User user);

    User deleteByName(String name);

    User save(User user);

    User getByName(String userName);
}
