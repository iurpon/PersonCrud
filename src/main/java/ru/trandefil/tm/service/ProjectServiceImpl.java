package ru.trandefil.tm.service;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    public Project getByName(String name) {
        return projectRepository.getByName(name);
    }

    public void delete(Project project) {
        projectRepository.delete(project);
    }

    public void deleteByName(String projectName) {
        projectRepository.deleteByName(projectName);

    }
}
