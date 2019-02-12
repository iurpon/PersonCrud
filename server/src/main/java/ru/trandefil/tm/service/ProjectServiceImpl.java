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
            return projectRepository.save(project);
        }
        Project updating = projectRepository.getById(project.getId());
        updating.setName(project.getName());
        updating.setDescription(project.getDescription());
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
    public Project getById(String name, String userId) {
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
    public void delete(Project project, String userId) {
        projectRepository.delete(project);
    }

    @Override
    public void deleteByName(String projectName, String userId) {
        projectRepository.deleteByName(projectName);
    }

    @Override
    public Project getByName(String projectName, String userId) {
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

}
