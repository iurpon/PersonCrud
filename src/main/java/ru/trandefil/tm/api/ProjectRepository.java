package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> getAll();

    Project getByName(final String name);

    void delete(final Project project);

    void deleteByName(final String projectName);
}
