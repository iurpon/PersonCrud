package ru.trandefil.tm.generated;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectEndPoint {

    @WebMethod
    Project saveProject(@WebParam(name = "project") Project project
            , @WebParam(name = "session") Session session);

    @WebMethod
    List<Project> getAllProjects(@WebParam(name = "session") Session session);

    @WebMethod
    Project getProjectById(@WebParam(name = "id") String id
            , @WebParam(name = "session") Session session);

    @WebMethod
    void deleteProject(@WebParam(name = "project") Project project
            , @WebParam(name = "session") Session session);

    @WebMethod
    void deleteProjectByName(@WebParam(name = "projectName") String projectName
            , @WebParam(name = "session") Session session);

    @WebMethod
    Project getProjectByName(@WebParam(name = "projectName") String projectName
            , @WebParam(name = "session") Session session);

}
