package ru.trandefil.tm.generated;

import ru.trandefil.tm.api.PublishEndPoint;
import ru.trandefil.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TaskEndPoint  extends PublishEndPoint {

    @WebMethod
    List<Task> getAll();

    @WebMethod
    Task save(@WebParam(name = "task") Task task);

    @WebMethod
    Task delete(@WebParam(name = "task") Task task);

    @WebMethod
    Task deleteByName(@WebParam(name = "name") String name);

    @WebMethod
    Task getByName(@WebParam(name = "name") String name);

}
