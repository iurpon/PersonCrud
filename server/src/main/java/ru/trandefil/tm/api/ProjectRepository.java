package ru.trandefil.tm.api;

import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectRepository {

    Project save(final Project project);

    List<Project> getAll();

    Project getById(final String id);

    Project getByName(final String name);

    void delete(final Project project);

    void deleteByName(final String projectName);

    void clear();

}
