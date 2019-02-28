package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.SessionRepository;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.util.EMFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    @Override
    public void clear(EntityManager em) {

        try {
            em.getTransaction().begin();
            final Query query = em.createQuery("TRUNCATE TABLE sessions;");
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
    }
}
