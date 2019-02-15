package ru.trandefil.tm.endpoint;

import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
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
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskService.getAll(session.getUserId());
    }

    @WebMethod
    @Override
    public Task updateTask(Task task, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskService.save(task);
    }

    @WebMethod
    @Override
    public Task saveTask(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "desc") String desc,
            @WebParam(name = "start") Date start,
            @WebParam(name = "end") Date end,
            @WebParam(name = "projectId") String projectId,
            @WebParam(name = "executorId") String executorId,
            @WebParam(name = "session") Session session
    ) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        Task newTask = new Task(id, name, desc, start, end, projectId, session.getUserId(), executorId);
        return taskService.save(newTask);
    }

    @WebMethod
    @Override
    public Task deleteTask(Task task, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskService.delete(task, session.getUserId());
    }

    @WebMethod
    @Override
    public Task deleteTaskByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskService.deleteByName(name, session.getUserId());
    }

    @WebMethod
    @Override
    public Task getTaskByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        return taskService.getByName(name, session.getUserId());
    }

}
