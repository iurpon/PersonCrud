package ru.trandefil.tm.service;


import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(String userId,Project project) {
        if(!project.getUserId().equals(userId)){
            throw new SecurityAuthorizationException(" modifying project denied.");
        }
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            System.out.format("saving new project : %s", project.getName());
            return projectRepository.save(project);
        }
        Project update = projectRepository.update(project);
        return update;
    }

    @Override
    public List<Project> getAll(String userId) {
        List<Project> filteredBySessionUserId = projectRepository.getAll(userId).stream()
                .filter(p -> p.getUserId().equals(userId))
                .collect(Collectors.toList());
        return filteredBySessionUserId;
    }

    @Override
    public Project getById(String userId, String name) {
        Project byId = projectRepository.getById(userId,name);
        if (byId == null) {
            System.out.println("Wrong project name.");
            return null;
        }
        if (!byId.getUserId().equals(userId)) {
            System.out.println("don't have permission to update this project.");
            return null;
        }
        return byId;
    }

    @Override
    public void delete(String userId, Project project) {
        if(!project.getUserId().equals(userId)){
            throw new SecurityAuthorizationException("delete project denied.");
        }
        projectRepository.delete(project);
    }

    @Override
    public void deleteByName(String userId, String projectName) {
        Project project = projectRepository.getByName(userId,projectName);
        if (!project.getUserId().equals(userId)) {
            throw new SecurityAuthorizationException("delete project denied.");
        }
        System.out.format("project %s deleted.", project.getName());
        projectRepository.delete(project);
    }

    @Override
    public Project getByName(String projectName,String userId) {
        Project byName = projectRepository.getByName(userId,projectName);
        if (byName == null) {
            System.out.println("Wrong project name.");
            return null;
        }
        if (!byName.getUserId().equals(userId)) {
            System.out.println("don't have permission to update this project.");
            return null;
        }
        return byName;
    }

}
