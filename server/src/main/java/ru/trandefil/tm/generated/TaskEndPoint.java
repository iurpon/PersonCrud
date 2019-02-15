package ru.trandefil.tm.generated;

import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface TaskEndPoint {

    @WebMethod
    List<Task> getAllTasks(@WebParam(name = "session") Session session);

    @WebMethod
    Task saveTask(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "desc") String desc,
            @WebParam(name = "start") Date start,
            @WebParam(name = "end") Date end,
            @WebParam(name = "projectId") String projectId,
            @WebParam(name = "executorId") String executorId,
            @WebParam(name = "session") Session session);

    @WebMethod
    Task updateTask(@WebParam(name = "task") Task task, @WebParam(name = "session") Session session);

    @WebMethod
    Task deleteTask(@WebParam(name = "task") Task task, @WebParam(name = "session") Session session);

    @WebMethod
    Task deleteTaskByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    Task getTaskByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

}
