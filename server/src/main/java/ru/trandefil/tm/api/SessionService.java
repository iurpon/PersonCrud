package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;

public interface SessionService {

    Session getSession(String id);

    Session saveSession(Session session);

}
