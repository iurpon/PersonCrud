package ru.trandefil.tm.repository;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.tm.entity.Project;

import java.util.List;

@Repository
public interface DSProjectRepository extends FullEntityRepository<Project,String> {

    @Override
    void persist(Project project);

    @Override
    Project merge(Project project);

    @Override
    Project getReference(Object pk);

    @Override
    Project findBy(String pk);

    @Query(value = "select p from Project p where p.name = :name")
    Project getByName(@NonNull @QueryParam("name") String name);

    @Override
    List<Project> findAll();

    @Override
    void remove(Project project);

    @Query(value = "delete from Project p where p.id = :id")
    int removeById(@NonNull @QueryParam("id") String id);

    @Query(value = "delete from Project p where p.name = :name")
    int removeByName(@NonNull @QueryParam("name") String name);

}
