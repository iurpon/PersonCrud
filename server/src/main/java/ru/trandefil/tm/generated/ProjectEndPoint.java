package ru.trandefil.tm.generated;

import ru.trandefil.tm.dto.ProjectDTO;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectEndPoint {

    @WebMethod
    ProjectDTO saveProject(@WebParam(name = "name") String name, @WebParam(name = "desc") String desc
            , @WebParam(name = "session") Session session);

    @WebMethod
    ProjectDTO updateProject(@WebParam(name = "project") ProjectDTO project, @WebParam(name = "session") Session session);

    @WebMethod
    List<ProjectDTO> getAllProjects(@WebParam(name = "session") Session session);

    @WebMethod
    ProjectDTO getProjectById(@WebParam(name = "id") String id
            , @WebParam(name = "session") Session session);

    @WebMethod
    void deleteProject(@WebParam(name = "project") ProjectDTO project
            , @WebParam(name = "session") Session session);

    @WebMethod
    void deleteProjectByName(@WebParam(name = "projectName") String projectName
            , @WebParam(name = "session") Session session);

    @WebMethod
    ProjectDTO getProjectByName(@WebParam(name = "projectName") String projectName
            , @WebParam(name = "session") Session session);

}
