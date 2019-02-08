package ru.trandefil.tm.generated;

import ru.trandefil.tm.api.PublishEndPoint;
import ru.trandefil.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

@WebService
public interface ProjectEndPoint  extends PublishEndPoint {

    @WebMethod
    Project saveProject(@WebParam(name = "project") Project project);

    @WebMethod
    List<Project> getAllProjects();

    @WebMethod
    Project getProjectById(@WebParam(name = "id") String id);

    @WebMethod
    void deleteProject(@WebParam(name = "project") Project project);

    @WebMethod
    void deleteProjectByName(@WebParam(name = "projectName") String projectName);

    @WebMethod
    Project getProjectByName(@WebParam(name = "projectName") String projectName);

    @WebMethod
    String getFile() throws IOException;

}
