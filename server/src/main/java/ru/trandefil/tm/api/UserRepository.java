package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserRepository {

    List<User> getAll(EntityManager entityManager);

    User getLogged(String login, String pass, EntityManager entityManager);

}
