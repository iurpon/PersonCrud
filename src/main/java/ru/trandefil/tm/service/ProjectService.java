package ru.trandefil.tm.service;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.AbstractRepository;
import ru.trandefil.tm.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements AbstractService{
    private AbstractRepository projectRepository;

    public ProjectService(AbstractRepository projectRepository) {
        this.projectRepository = projectRepository;
    }




    public List<Project> getAll() {
        return new ArrayList(((ProjectRepository)projectRepository).projects.values());
    }
}
