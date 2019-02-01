package ru.trandefil.tm.service;

import ru.trandefil.tm.entity.BaseEntity;
import ru.trandefil.tm.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<BaseEntity> projectList(){
        return new ArrayList<>(projectRepository.projects.values());
    }
}
