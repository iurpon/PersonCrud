package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectRepository {

    List<Project> getAll(String userId, EntityManager em);

    List<Project> getAll(EntityManager em);

    Project getByName(String userId, String projectName, EntityManager em);

    Project getById(String userId, String projectId, EntityManager em);

    Project save(Project project, EntityManager em);

    void delete(Project project, EntityManager em);

    boolean deleteByName(String userId, String projectName, EntityManager em);

    void clear();

}
