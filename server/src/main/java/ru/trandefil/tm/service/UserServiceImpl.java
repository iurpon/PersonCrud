package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.EMFactory;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public User deleteByName(String name) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User getByName(String userName) {
        return null;
    }

    @Override
    public List<User> getAll() {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        List<User> users = userRepository.getAll(em);
        em.getTransaction().commit();
        em.close();
        return users;
    }

    @Override
    public Session getSession(String userName, String userPassword) {
        EntityManager em = EMFactory.getEntityManager();
        em.getTransaction().begin();
        User user = userRepository.getLogged(userName,userPassword,em);
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
    public void logout(String sessionId) {

    }

    @Override
    public User constractUser(String name, String pass, String role) {
        return null;
    }
}
