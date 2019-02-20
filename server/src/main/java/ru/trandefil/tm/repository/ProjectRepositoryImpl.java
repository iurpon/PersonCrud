package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepositoryImpl implements ProjectRepository {
    @Override
    public void delete(Project project) {

    }

    @Override
    public Project update(Project project) {
        return null;
    }

    private Map<String, Project> projects = new HashMap<>();

    @Override
    public void clear() {
        projects.clear();
    }

    @Override
    public Project save(Project project) {
        projects.put(project.getId(), project);
        return project;
    }

    @Override
    public List<Project> getAll(String userId) {
        return new ArrayList<>(projects.values());
    }

    @Override
    public Project getById(String userId, String id) {
        return projects.get(id);
    }

    @Override
    public Project getByName(String userId, String projectName) {
        return getAll(userId).stream()
                .filter(p -> p.getName().equals(projectName))
                .findAny()
                .orElse(null);
    }

//    @Override
    public void delete(String userId, Project project) {
        projects.remove(project.getId());
    }

    @Override
    public void deleteByName(String userId, String projectName) {
        final Project project = getByName(userId,projectName);
        if (project == null) {
            return;
        }
        delete(userId,project);
    }

//    @Override
    public Project update(String userId,Project project) {
        return null;
    }


}
