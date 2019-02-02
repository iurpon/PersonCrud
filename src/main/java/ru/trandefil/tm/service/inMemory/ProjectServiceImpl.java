package ru.trandefil.tm.service.inMemory;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepository;
import ru.trandefil.tm.repository.inMemory.ProjectRepositoryImpl;
import ru.trandefil.tm.service.ProjectService;

import java.util.ArrayList;
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
