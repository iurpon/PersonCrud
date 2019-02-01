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


    public Project save(Project project){
        ((ProjectRepository)projectRepository).projects.put(project.getName(),project);
        return project;
    }

    public List<Project> getAll() {
        return new ArrayList(((ProjectRepository)projectRepository).projects.values());
    }

    public Project getByName(String name) {
        return ((ProjectRepository) projectRepository).projects.get(name);
    }

    public void delete(Project project){
        ((ProjectRepository) projectRepository).projects.remove(project.getName());
    }

    public void deleteByName(String projectName){
        Project removed = ((ProjectRepository) projectRepository).projects.remove(projectName);
        if(removed != null){
            System.out.println("LOGGER: object removed");

        }else{
            System.out.println("LOGGER: no this name object ");
        }

    }
}
