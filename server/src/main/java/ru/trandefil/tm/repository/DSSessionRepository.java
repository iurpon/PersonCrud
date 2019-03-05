package ru.trandefil.tm.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.tm.entity.Session;

@Repository
public interface DSSessionRepository extends FullEntityRepository<Session, String> {

    @Override
    void persist(Session session);

    @Override
    void clear();

    @Override
    void remove(Session session);

}
