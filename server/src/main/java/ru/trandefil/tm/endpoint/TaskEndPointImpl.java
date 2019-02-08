package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.generated.TaskEndPoint;

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

    @Override
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @Override
    public Task save(Task task) {
        return taskService.save(task);
    }

    @Override
    public Task delete(Task task) {
        return taskService.delete(task);
    }

    @Override
    public Task deleteByName(String name) {
        return taskService.deleteByName(name);
    }

    @Override
    public Task getByName(String name) {
        return taskService.getByName(name);
    }

    @Override
    public void publish() {
        Endpoint endpoint = Endpoint.create(this);
        endpoint.publish("http://localhost:8082/taskEndPoint?wsdl");
    }

}
