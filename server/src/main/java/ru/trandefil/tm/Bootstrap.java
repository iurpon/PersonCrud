package ru.trandefil.tm;

import ru.trandefil.tm.api.*;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.endpoint.ProjectEndPointImpl;
import ru.trandefil.tm.endpoint.TaskEndPointImpl;
import ru.trandefil.tm.endpoint.UserEndPointImpl;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.service.UserServiceImpl;

import java.util.*;

public class Bootstrap implements ServiceLocator {

    private User loggedUser = null;

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final TerminalService terminalService = new TerminalService(new Scanner(System.in));

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository);

    private final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService);

    private final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService);

    private final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    private final List<PublishEndPoint> publishEndPoints = new ArrayList<>();

    public TaskEndPoint getTaskEndPoint() {
        return taskEndPoint;
    }

    public UserEndPoint getUserEndPoint() {
        return userEndPoint;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    public Map<String, AbstractCommand> getCommandMap() {
        return commandMap;
    }

    @Override
    public ProjectService getProjectService() {
        return this.projectService;
    }

    @Override
    public TaskService getTaskService() {
        return this.taskService;
    }

    @Override
    public ProjectEndPoint getProjectEndPoint() {
        return projectEndPoint;
    }

    @Override
    public TerminalService getTerminalService() {
        return this.terminalService;
    }

    @Override
    public UserService getUserService() {
        return this.userService;
    }

    public void fillAbstractEndPoint(){
        publishEndPoints.add(projectEndPoint);
        publishEndPoints.add(userEndPoint);
        publishEndPoints.add(taskEndPoint);
    }

    public void init() {
        fillAbstractEndPoint();
        publishEndPoints.forEach(PublishEndPoint::publish);
    }

}
