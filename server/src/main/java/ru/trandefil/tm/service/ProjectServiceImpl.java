package ru.trandefil.tm.service;


import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            System.out.format("saving new project : %s", project.getName());
            return projectRepository.save(project);
        }
        Project updating = projectRepository.getById(project.getId());
        if (updating == null) {
            System.out.println("id incorrect. project save fail.");
            return null;
        }
        updating.setName(project.getName());
        updating.setDescription(project.getDescription());
//        projectRepository.save(updating);
        projectRepository.update(updating);
        System.out.format("updated project : %s", project.getName());
        return updating;
    }

    @Override
    public List<Project> getAll(String userId) {
        List<Project> filteredBySessionUserId = projectRepository.getAll().stream()
                .filter(p -> p.getUserId().equals(userId))
                .collect(Collectors.toList());
        return filteredBySessionUserId;
    }

    @Override
    public Project getById(String userId, String name) {
        Project byId = projectRepository.getById(name);
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
        projectRepository.delete(project);
    }

    @Override
    public void deleteByName(String userId, String projectName) {
        Project project = projectRepository.getByName(projectName);
        if (!project.getUserId().equals(userId)) {
            return;
        }
        System.out.format("project %s deleted.", project.getName());
        projectRepository.deleteByName(project.getUserId());
    }

    @Override
    public Project getByName(String userId, String projectName) {
        Project byName = projectRepository.getByName(projectName);
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

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

}
