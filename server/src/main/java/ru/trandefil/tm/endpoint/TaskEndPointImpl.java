package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.generated.TaskEndPoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.TaskEndPoint")
public class TaskEndPointImpl implements TaskEndPoint {

    private TaskService taskService;

    public TaskEndPointImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @WebMethod
    @Override
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @WebMethod
    @Override
    public Task saveTask(Task task) {
        return taskService.save(task);
    }

    @WebMethod
    @Override
    public Task deleteTask(Task task) {
        return taskService.delete(task);
    }

    @WebMethod
    @Override
    public Task deleteTaskByName(String name) {
        return taskService.deleteByName(name);
    }

    @WebMethod
    @Override
    public Task getTaskByName(String name) {
        return taskService.getByName(name);
    }

}
