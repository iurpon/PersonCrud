package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.ProjectEndPoint")
public class ProjectEndPointImpl extends AbstractEndPoint implements ProjectEndPoint {

    private ProjectService projectService;

    public ProjectEndPointImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public Project save(Project project) {
        return projectService.save(project);
    }

    @Override
    public List<Project> getAll() {
        return projectService.getAll();
    }

    @Override
    public Project getById(String id) {
        return projectService.getById(id);
    }

    @Override
    public void delete(Project project) {
        projectService.delete(project);
    }

    @Override
    public void deleteByName(String projectName) {
        projectService.deleteByName(projectName);
    }

    @Override
    public Project getByName(String projectName) {
        return projectService.getByName(projectName);
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/projectEndPoint?wsdl",
                new ProjectEndPointImpl(new ProjectServiceImpl(new ProjectRepositoryImpl())));
    }

    @Override
    void publish() {
//        Endpoint.publish()
    }
}
