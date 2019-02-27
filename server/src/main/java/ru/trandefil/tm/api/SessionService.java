package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;

public interface SessionService {

    void delete(Session session);

    Session save(Session session);

}
