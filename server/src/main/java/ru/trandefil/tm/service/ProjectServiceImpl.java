package ru.trandefil.tm.service;


import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.util.SignatureUtil;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
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
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        List<Project> filteredBySessionUserId = projectRepository.getAll().stream()
                .filter(p -> p.getUserId().equals(session.getUserId()))
                .collect(Collectors.toList());
        return filteredBySessionUserId;

    }

    public Project getById(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        Project byId = projectRepository.getById(name);
        if(byId == null){
            System.out.println("Wrong project name.");
            return null;
        }
        if(!byId.getUserId().equals(session.getUserId())){
            System.out.println("don't have permission to update this project.");
            return null;
        }
        return byId;
    }

    public void delete(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        projectRepository.delete(project);
    }

    public void deleteByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        projectRepository.deleteByName(projectName);
    }

    @Override
    public Project getByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        Project byName = projectRepository.getByName(projectName);
        if(byName == null){
            System.out.println("Wrong project name.");
            return null;
        }
        if(!byName.getUserId().equals(session.getUserId())){
            System.out.println("don't have permission to update this project.");
            return null;
        }
        return byName;
    }

}
