package ru.trandefil.tm.service;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public Project save(Project project){
        projectRepository.projects.put(project.getName(),project);
        return project;
    }

    public List<Project> getAll() {
        return new ArrayList(projectRepository.projects.values());
    }

    public Project getByName(String name) {
        return  projectRepository.projects.get(name);
    }

    public void delete(Project project){
       projectRepository.projects.remove(project.getName());
    }

    public void deleteByName(String projectName){
        Project removed =  projectRepository.projects.remove(projectName);
        if(removed != null){
            System.out.println("LOGGER: object removed");
            return;
        }else{
            System.out.println("LOGGER: no this name object ");
            return;
        }

    }
}
