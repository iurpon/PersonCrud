package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> getAll(@NonNull EntityManager em) {
        Query query = em.createQuery("select u from User u");
        List<User> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public User getLogged(@NonNull String login, @NonNull String pass, @NonNull EntityManager em) {
        Query query = em.createQuery("Select u FROM User u WHERE u.name = :name and u.password = :password");
        query.setParameter("name", login);
        query.setParameter("password", pass);
        User logged = (User) query.getSingleResult();
        return logged;
    }

}
