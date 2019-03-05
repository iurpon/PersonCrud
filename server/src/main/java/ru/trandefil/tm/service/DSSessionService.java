package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.trandefil.tm.api.SessionService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.exception.RepositoryLayerException;
import ru.trandefil.tm.repository.DSSessionRepository;

import javax.inject.Inject;
import java.util.logging.Logger;

@Transactional
public class DSSessionService implements SessionService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private DSSessionRepository sessionRepository;

    @Override
    public void delete(@NonNull final Session session) {
        try {
            sessionRepository.remove(session);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Session save(@NonNull final Session session) {
        try {
            sessionRepository.persist(session);
            return session;
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

}
