package ru.trandefil.tm.generated;

import ru.trandefil.tm.entity.Project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProjectEndPoint {

    @WebMethod
    Project save(@WebParam(name = "project") Project project);

    @WebMethod
    List<Project> getAll();

    @WebMethod
    Project getById(@WebParam(name = "id") String id);

    @WebMethod
    void delete(@WebParam(name = "project") Project project);

    @WebMethod
    void deleteByName(@WebParam(name = "projectName") String projectName);

    @WebMethod
    Project getByName(@WebParam(name = "projectName") String projectName);

}
