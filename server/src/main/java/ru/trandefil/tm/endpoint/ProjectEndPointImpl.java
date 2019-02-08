package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.generated.ProjectEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.ProjectEndPoint")
public class ProjectEndPointImpl implements ProjectEndPoint {

    private ProjectService projectService;

    public ProjectEndPointImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @WebMethod
    @Override
    public Project save(Project project) {
        return projectService.save(project);
    }

    @WebMethod
    @Override
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @WebMethod
    @Override
    public Project getById(String id) {
        return projectService.getById(id);
    }

    @WebMethod
    @Override
    public void delete(Project project) {
        projectService.delete(project);
    }

    @WebMethod
    @Override
    public void deleteByName(String projectName) {
        projectService.deleteByName(projectName);
    }

    @WebMethod
    @Override
    public Project getByName(String projectName) {
        return projectService.getByName(projectName);
    }

    @Override
    public void publish() {
        Endpoint endpoint = Endpoint.create(this);
        endpoint.publish("http://localhost:8080/projectEndPoint?wsdl");
    }

}
