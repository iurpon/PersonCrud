package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Session;

public interface SessionService {

    Session getSession(String id);

    Session saveSassion(Session session,String userId);

}
