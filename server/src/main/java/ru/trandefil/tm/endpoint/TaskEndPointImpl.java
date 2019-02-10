package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.generated.TaskEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.TaskEndPoint")
public class TaskEndPointImpl implements TaskEndPoint {

    private TaskService taskService;

    public TaskEndPointImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @WebMethod
    @Override
    public List<Task> getAllTasks(Session session) {
        return taskService.getAll(session);
    }

    @WebMethod
    @Override
    public Task saveTask(Task task, Session session) {
        return taskService.save(task, session);
    }

    @WebMethod
    @Override
    public Task deleteTask(Task task, Session session) {
        return taskService.delete(task, session);
    }

    @WebMethod
    @Override
    public Task deleteTaskByName(String name, Session session) {
        return taskService.deleteByName(name, session);
    }

    @WebMethod
    @Override
    public Task getTaskByName(String name, Session session) {
        return taskService.getByName(name, session);
    }

}
