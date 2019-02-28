package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.SessionRepository;
import ru.trandefil.tm.entity.Session;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class SessionRepositoryImpl implements SessionRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void delete(@NonNull final Session session, @NonNull final EntityManager em) {
        logger.info("delete session repo");
        em.remove(session);
    }

    @Override
    public Session save(@NonNull final Session session, @NonNull final EntityManager em) {
        logger.info("save session repo");
        em.persist(session);
        return session;
    }

}
