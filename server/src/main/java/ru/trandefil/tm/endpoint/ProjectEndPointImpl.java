package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.generated.ProjectEndPoint;

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
        return projectService.save(project, session);
    }

    @WebMethod
    @Override
    public List<Project> getAllProjects(Session session) {
        return projectService.getAll(session);
    }

    @WebMethod
    @Override
    public Project getProjectById(String id, Session session) {
        return projectService.getById(id, session);
    }

    @WebMethod
    @Override
    public void deleteProject(Project project, Session session) {
        projectService.delete(project, session);
    }

    @WebMethod
    @Override
    public void deleteProjectByName(String projectName, Session session) {
        projectService.deleteByName(projectName, session);
    }

    @WebMethod
    @Override
    public Project getProjectByName(String projectName, Session session) {
        return projectService.getByName(projectName, session);
    }

}
