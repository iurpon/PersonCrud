package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class UserRepositoryImpl implements UserRepository {

    private Logger logger = Logger.getLogger(this.getClass().getName());

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

    @Override
    public User findByName(String name, EntityManager em) {
        Query query = em.createQuery("Select u FROM User u WHERE u.name = :name");
        query.setParameter("name", name);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public User getRef(String userId, EntityManager em) {
        return em.getReference(User.class,userId);
    }

    @Override
    public User getById(String userId, EntityManager em) {
        Query query = em.createQuery("select u from User u where u.id = :userId");
        query.setParameter("userId",userId);
        User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public User saveOrUpdate(User user, EntityManager em) {
        if(user.isNew()){
            user.setId(UUIDUtil.getUniqueString());
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    @Override
    public void delete(User user, EntityManager em) {
        em.remove(user);
    }

    @Override
    public boolean deleteByName(String name, EntityManager em) {
        User byName = findByName(name, em);
        if (byName != null) {
            return deleteById(byName.getId(), em);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id, EntityManager em) {
        Query query = em.createQuery("Delete FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        int executeUpdate = query.executeUpdate();
        return executeUpdate != 0;
    }

}
