package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectService {

    Project save(String userId, String name, String description);

    List<Project> getAll(String userId);

    List<Project> getAll();

    Project getById(String id, String userId);

    void delete(String userId, Project project);

    boolean deleteByName(String userId, String projectName);

    Project getByName(String userId, String projectName);

    Project update(Project project);

}
