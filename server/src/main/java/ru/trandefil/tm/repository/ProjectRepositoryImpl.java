package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepositoryImpl implements ProjectRepository {

    private Map<String, Project> projects = new HashMap<>();

    @Override
    public void clear() {
        projects.clear();
    }

    @Override
    public Project save(final Project project) {
        projects.put(project.getId(), project);
        return project;
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public Project getById(final String id) {
        return projects.get(id);
    }

    @Override
    public Project getByName(String projectName) {
        return getAll().stream()
                .filter(p -> p.getName().equals(projectName))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(final Project project) {
        projects.remove(project.getId());
    }

    @Override
    public void deleteByName(final String projectName) {
        final Project project = getByName(projectName);
        if (project == null) {
            return;
        }
        delete(project);
    }

}
