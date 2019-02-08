package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.TaskEndPoint")
public class TaskEndPointImpl  implements TaskEndPoint {

    private TaskService taskService;

    public TaskEndPointImpl(TaskService taskService) {
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

}
