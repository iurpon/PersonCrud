package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectService {

    Project save(String userId,Project project);

    List<Project> getAll(String userId);

    Project getById(String id, String userId);

    void delete(String userId, Project project);

    void deleteByName(String userId, String projectName);

    Project getByName(String userId, String projectName);

}
