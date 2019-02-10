package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;

import java.util.List;

public interface ProjectService {

    Project save(Project project, Session session);

    List<Project> getAll(Session session);

    Project getById(String id, Session session);

    void delete(Project project, Session session);

    void deleteByName(String projectName, Session session);

    Project getByName(String projectName, Session session);

}
