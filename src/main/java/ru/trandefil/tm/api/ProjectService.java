package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    List<Project> getAll();

    Project getByName(String name);

    void delete(Project project);

    void deleteByName(String projectName);

}
