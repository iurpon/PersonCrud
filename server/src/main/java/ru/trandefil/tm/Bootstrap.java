package ru.trandefil.tm;

import ru.trandefil.tm.api.*;
import ru.trandefil.tm.endpoint.AdminEndPointImpl;
import ru.trandefil.tm.endpoint.ProjectEndPointImpl;
import ru.trandefil.tm.endpoint.TaskEndPointImpl;
import ru.trandefil.tm.endpoint.UserEndPointImpl;
import ru.trandefil.tm.generated.AdminEndPoint;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.SessionRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.AdminServiceImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
public class Bootstrap {

    @Inject
    private UserRepository userRepository;

    private final SessionRepository sessionRepository = new SessionRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository,sessionRepository);

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository, userService);

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService,userService);

    private final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService,projectService,userService);

    private final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    private final AdminService adminService = new AdminServiceImpl(
            projectService,
            userService,
            taskService);

    private final AdminEndPoint adminEndPoint = new AdminEndPointImpl(adminService);

    public void init() {
        Endpoint.publish("http://localhost:8080/projectEndPoint?wsdl", projectEndPoint);
        Endpoint.publish("http://localhost:8080/taskEndPoint?wsdl", taskEndPoint);
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl", userEndPoint);
        Endpoint.publish("http://localhost:8080/adminEndPoint?wsdl", adminEndPoint);
    }

}
