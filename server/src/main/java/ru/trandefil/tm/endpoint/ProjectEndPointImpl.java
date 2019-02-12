package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    private ProjectService projectService;

    public ProjectEndPointImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Project saveProject(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return projectService.save(project);
    }

    @WebMethod
    @Override
    public List<Project> getAllProjects(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return projectService.getAll(session.getUserId());
    }

    @WebMethod
    @Override
    public Project getProjectById(String id, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return projectService.getById(id, session.getUserId());
    }

    @WebMethod
    @Override
    public void deleteProject(Project project, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        projectService.delete(project, session.getUserId());
    }

    @WebMethod
    @Override
    public void deleteProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return;
        }
        projectService.deleteByName(projectName, session.getUserId());
    }

    @WebMethod
    @Override
    public Project getProjectByName(String projectName, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return projectService.getByName(projectName, session.getUserId());
    }

}
