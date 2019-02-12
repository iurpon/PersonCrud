package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<Project> getAll(String userId);

    Project getById(String id, String userId);

    void delete(Project project, String userId);

    void deleteByName(String projectName, String userId);

    Project getByName(String projectName, String userId);

}
