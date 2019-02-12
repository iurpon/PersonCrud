package ru.trandefil.tm.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-12T18:46:28.463+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://generated.tm.trandefil.ru/", name = "ProjectEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndPoint {

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/getProjectByNameRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/getProjectByNameResponse")
    @RequestWrapper(localName = "getProjectByName", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetProjectByName")
    @ResponseWrapper(localName = "getProjectByNameResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetProjectByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.tm.generated.Project getProjectByName(
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/saveProjectRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/saveProjectResponse")
    @RequestWrapper(localName = "saveProject", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.SaveProject")
    @ResponseWrapper(localName = "saveProjectResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.SaveProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.tm.generated.Project saveProject(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "desc", targetNamespace = "")
        java.lang.String desc,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/deleteProjectRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/deleteProjectResponse")
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "project", targetNamespace = "")
        ru.trandefil.tm.generated.Project project,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/updateProjectRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/updateProjectResponse")
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.UpdateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.tm.generated.Project updateProject(
        @WebParam(name = "project", targetNamespace = "")
        ru.trandefil.tm.generated.Project project,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/deleteProjectByNameRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/deleteProjectByNameResponse")
    @RequestWrapper(localName = "deleteProjectByName", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.DeleteProjectByName")
    @ResponseWrapper(localName = "deleteProjectByNameResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.DeleteProjectByNameResponse")
    public void deleteProjectByName(
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/getAllProjectsRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/getAllProjectsResponse")
    @RequestWrapper(localName = "getAllProjects", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetAllProjects")
    @ResponseWrapper(localName = "getAllProjectsResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.trandefil.tm.generated.Project> getAllProjects(
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );

    @WebMethod
    @Action(input = "http://generated.tm.trandefil.ru/ProjectEndPoint/getProjectByIdRequest", output = "http://generated.tm.trandefil.ru/ProjectEndPoint/getProjectByIdResponse")
    @RequestWrapper(localName = "getProjectById", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetProjectById")
    @ResponseWrapper(localName = "getProjectByIdResponse", targetNamespace = "http://generated.tm.trandefil.ru/", className = "ru.trandefil.tm.generated.GetProjectByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.trandefil.tm.generated.Project getProjectById(
        @WebParam(name = "id", targetNamespace = "")
        java.lang.String id,
        @WebParam(name = "session", targetNamespace = "")
        ru.trandefil.tm.generated.Session session
    );
}
