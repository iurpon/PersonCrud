package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.SessionRepository;
import ru.trandefil.tm.entity.Session;

import java.util.HashMap;
import java.util.Map;

public class SessionRepositoryImpl implements SessionRepository {

    private Map<String,Session> sessionMap = new HashMap<>();

    @Override
    public Session getSession(String id) {
        return sessionMap.get(id);
    }

    @Override
    public Session save(Session session) {
        return sessionMap.put(session.getId(),session);
    }

}
