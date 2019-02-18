package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    private ProjectService projectService;

    public ProjectEndPointImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Project saveProject(String name, String description, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        Project created = new Project(null, name, description, session.getUserId());
        return projectService.save(session.getUserId(), created);
    }

    @Override
    public Project updateProject(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return projectService.save(session.getUserId(), project);
    }

    @Override
    public List<Project> getAllProjects(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return projectService.getAll(session.getUserId());
    }

    @Override
    public Project getProjectById(String id, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return projectService.getById(id, session.getUserId());
    }

    @Override
    public void deleteProject(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        projectService.delete(session.getUserId(), project);
    }

    @Override
    public void deleteProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        projectService.deleteByName(session.getUserId(),projectName );
    }

    @Override
    public Project getProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return projectService.getByName(projectName, session.getUserId());
    }

}
