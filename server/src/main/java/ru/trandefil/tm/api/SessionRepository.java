package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;

public interface SessionRepository {

    Session getSession(String id);

    Session save(Session session);

}
