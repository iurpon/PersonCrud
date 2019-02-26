package ru.trandefil.tm.endpoint;

import lombok.NonNull;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.dto.TaskDTO;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "ru.trandefil.tm.generated.TaskEndPoint")
public class TaskEndPointImpl implements TaskEndPoint {

    private final TaskService taskService;

    private final ProjectService projectService;

    private final UserService userService;

    public TaskEndPointImpl(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @WebMethod
    @Override
    public List<TaskDTO> getAllTasks(@NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            return null;
        }
        List<Task> tasks = taskService.getAll(session.getUserId());
        return getTaskListDTO(tasks);
    }

    @WebMethod
    @Override
    public TaskDTO updateTask(@NonNull final TaskDTO taskDTO, @NonNull final Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("auth exc.");
        }
        final Task task = getTaskEntity(taskDTO, session.getUserId());
        final Task updated = taskService.save(session.getUserId(), task);
        final TaskDTO dto = getTaskDTO(updated);
        return dto;
    }

    @WebMethod
    @Override
    public TaskDTO saveTask(
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
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Project project = projectService.getById(projectId, session.getUserId());
        final User assignee = userService.getById(session.getUserId());
        final User executor = userService.getById(executorId);
        final Task newTask = new Task(id, name, desc, start, end, project, assignee, executor);
        final Task saved = taskService.save(session.getUserId(), newTask);
        return getTaskDTO(saved);
    }

    @WebMethod
    @Override
    public TaskDTO deleteTask(TaskDTO taskDTO, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final Task task = getTaskEntity(taskDTO,session.getUserId());
        return null;
    }

    @WebMethod
    @Override
    public TaskDTO deleteTaskByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        return null;
    }

    @WebMethod
    @Override
    public TaskDTO getTaskByName(String name, Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        Task task = taskService.getByName(session.getUserId(), name);
        return getTaskDTO(task);
    }

    private TaskDTO getTaskDTO(@NonNull Task task) {
        return new TaskDTO(task);
    }

    private List<TaskDTO> getTaskListDTO(@NonNull List<Task> tasks) {
        final List<TaskDTO> taskDTOS = new ArrayList<>();
        tasks.forEach(task -> taskDTOS.add(getTaskDTO(task)));
        return taskDTOS;
    }

    private Task getTaskEntity(@NonNull TaskDTO taskDTO, String userId) {
        final Project project = projectService.getByName(userId, taskDTO.getProjectName());
        final User assigner = userService.getByName(taskDTO.getAssigneeName());
        final User executor = userService.getByName(taskDTO.getExecutorName());
        return new Task(taskDTO.getId(), taskDTO.getName(),
                taskDTO.getDescription(), taskDTO.getBegin(), taskDTO.getEnd(),
                project, assigner, executor);
    }

}
