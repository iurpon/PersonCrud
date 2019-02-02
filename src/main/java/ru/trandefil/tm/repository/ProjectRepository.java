package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> getAll();

    Project getByName(String name);

    void delete(Project project);

    void deleteByName(String projectName);
}
