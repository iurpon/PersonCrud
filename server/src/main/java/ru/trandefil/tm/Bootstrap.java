package ru.trandefil.tm;

import ru.trandefil.tm.api.*;
import ru.trandefil.tm.endpoint.ProjectEndPointImpl;
import ru.trandefil.tm.endpoint.TaskEndPointImpl;
import ru.trandefil.tm.endpoint.UserEndPointImpl;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import javax.xml.ws.Endpoint;

public class Bootstrap implements ServiceLocator {

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository);

    private final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService);

    private final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService);

    private final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    @Override
    public ProjectService getProjectService() {
        return this.projectService;
    }

    @Override
    public TaskService getTaskService() {
        return this.taskService;
    }

    @Override
    public UserService getUserService() {
        return this.userService;
    }

    public void init() {
        Endpoint.publish("http://localhost:8080/projectEndPoint?wsdl", projectEndPoint);
        Endpoint.publish("http://localhost:8080/taskEndPoint?wsdl", taskEndPoint);
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl", userEndPoint);
    }

}
