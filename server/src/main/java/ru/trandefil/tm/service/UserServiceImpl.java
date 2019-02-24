package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.EMFactoryUtil;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void delete(@NonNull User user) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        userRepository.delete(user, em);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public boolean deleteByName(@NonNull String name) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final boolean isDeleted = userRepository.deleteByName(name, em);
        em.getTransaction().commit();
        em.close();
        return isDeleted;
    }

    @Override
    public User save(@NonNull User user) {
        if (user.isNew()) {
            user.setId(UUIDUtil.getUniqueString());
        }
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        userRepository.saveOrUpdate(user, em);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    @Override
    public User getByName(@NonNull String userName) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User user = userRepository.findByName(userName, em);
//        em.getTransaction().commit();
        em.close();
        return user;
    }

    @Override
    public User getRefById(@NonNull String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User ref = userRepository.getRef(userId, em);
        em.close();
        return ref;
    }

    @Override
    public List<User> getAll() {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final List<User> users = userRepository.getAll(em);
//        em.getTransaction().commit();
        em.close();
        return users;
    }

    @Override
    public Session getSession(@NonNull String userName, @NonNull String userPassword) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User user = userRepository.getLogged(userName, HashUtil.hashPassword(userPassword), em);
        if (user == null) {
            System.out.println("bad login.");
            return null;
        }
        em.getTransaction().commit();
        em.close();
        System.out.println("logged " + user.getName());
        final Session newSess = createNewSession(user.getId(), user.getRole());
        return newSess;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role) {
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        return created;
    }

    @Override
    public void logout(@NonNull String sessionId) {

    }

    @Override
    public User constractUser(@NonNull String name, @NonNull String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            final Role newRole = Enum.valueOf(Role.class, role);
            final User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            return save(newUser);
        }
        System.out.println("bad user role.");
        return null;
    }

}
