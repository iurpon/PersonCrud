package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.DataBaseException;
import ru.trandefil.tm.repository.DSSessionRepository;
import ru.trandefil.tm.repository.DSUserRepository;
import ru.trandefil.tm.util.HashUtil;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Transactional
public class DSUserService implements UserService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private DSUserRepository userRepository;

    @Inject
    private DSSessionRepository sessionRepository;

    @Override
    public User getRefById(String id) {
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public boolean deleteByName(String name) {
        return false;
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
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    @Override
    public Session getSession(@NonNull final String userName, @NonNull final String userPassword) {
        try {
            logger.info("get session");
            final User user = userRepository.getLoggedUser(userName, HashUtil.hashPassword(userPassword));
            if (user == null) {
                System.out.println("bad login.");
                return null;
            }
            logger.info("get form base user : " + user);
            final Session newSess = createNewSession(user.getId(), user.getRole());
            logger.info("created session : " + newSess);
            System.out.println("logged " + user.getName());
            return newSess;
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role) {
        logger.info("create new sesion");
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        sessionRepository.persist(created);
        return created;
    }

    @Override
    public void logout(Session session) {
        try {
            sessionRepository.remove(session);
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    @Override
    public User constractUser(@NonNull final String name, @NonNull final String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            final Role newRole = Enum.valueOf(Role.class, role);
            final User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            final User saved = save(newUser);
            return saved;
        }
        System.out.println("bad user role.");
        return null;
    }

}
