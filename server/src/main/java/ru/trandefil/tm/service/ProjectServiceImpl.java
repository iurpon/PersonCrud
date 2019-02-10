package ru.trandefil.tm.service;


import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project, Session session) {
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            return projectRepository.save(project);
        }
        Project updating = projectRepository.getById(project.getId());
        updating.setName(project.getName());
        updating.setDescription(project.getDescription());
        return updating;
    }

    public List<Project> getAll(Session session) {
        return projectRepository.getAll();
    }

    public Project getById(String name, Session session) {
        return projectRepository.getById(name);
    }

    public void delete(Project project, Session session) {
        projectRepository.delete(project);
    }

    public void deleteByName(String projectName, Session session) {
        projectRepository.deleteByName(projectName);
    }

    @Override
    public Project getByName(String projectName, Session session) {
        return projectRepository.getByName(projectName);
    }

}
