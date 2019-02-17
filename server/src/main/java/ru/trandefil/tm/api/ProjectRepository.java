package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> getAll(String userId);

    Project getById(String userId, String id);

    Project getByName(String userId, String name);

    void delete(String userId, Project project);

    void deleteByName(String userId, String projectName);

    void clear();

    Project update(String userId,Project project);

}
