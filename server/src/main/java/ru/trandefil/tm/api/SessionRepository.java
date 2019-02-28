package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;

import javax.persistence.EntityManager;

public interface SessionRepository {

    void delete(Session session, EntityManager em);

    Session save(Session session, EntityManager em);

    void clear(EntityManager em);

}
