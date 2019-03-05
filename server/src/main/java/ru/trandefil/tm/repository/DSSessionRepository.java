package ru.trandefil.tm.repository;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.tm.entity.Session;

@Repository
public interface DSSessionRepository extends FullEntityRepository<Session, String> {

    @Override
    void persist(Session session);

    @Override
    void clear();

    @Override
    void remove(@NonNull Session session);

    @Query(value = "delete from Session s where s.id = :sessionId")
    void deleteSession(@NonNull @QueryParam("sessionId") String sessionId);



}
