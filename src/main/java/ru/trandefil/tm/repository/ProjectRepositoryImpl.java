package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ProjectRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepositoryImpl implements ProjectRepository {

    private Map<String, Project> projects = new HashMap<>();

    {
        projects.put("simpleProject", new Project("id", "simpleProject", "no description"));
    }

    @Override
    public Project save(Project project) {
        projects.put(project.getName(), project);
        return project;
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public Project getByName(String name) {
        return projects.get(name);
    }

    @Override
    public void delete(Project project) {
        projects.remove(project.getName());
    }

    @Override
    public void deleteByName(String projectName) {
        projects.remove(projectName);
    }

}
