package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.SessionRepository;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;

public class SessionRepositoryImpl implements SessionRepository {

    @Override
    public void delete(Session session, EntityManager em) {
        em.remove(session);
    }

    @Override
    public Session save(Session session, EntityManager em) {
        session.setId(UUIDUtil.getUniqueString());
        em.persist(session);
        return session;
    }

}
