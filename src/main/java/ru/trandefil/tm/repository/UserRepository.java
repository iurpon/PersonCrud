package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserRepository {


    User delete(User user);

    User deleteByName(String name);

    User save(User user);

    User getByName(String userName);

    List<User> getAll();
}
