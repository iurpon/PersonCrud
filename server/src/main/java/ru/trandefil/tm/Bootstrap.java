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
import ru.trandefil.tm.repository.*;
import ru.trandefil.tm.service.*;

import javax.xml.ws.Endpoint;

public class Bootstrap implements ServiceLocator {

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ConnectionService connectionService = new ConnectionServiceImpl();

    private final SqlSessionService sqlSessionService = new SqlSessionServiceImpl();

    private final ProjectRepository mbProjectRepository = new ProjectMBRepositoryImpl(sqlSessionService);

    private final UserRepository mbUserRepository = new UserMBRepositoryImpl(sqlSessionService);

    private final ProjectRepository dbProjectRepository = new ProjectDBRepositoryImpl(connectionService);

    private final UserRepository dbUserRepository = new UserDBRepositoryImpl(connectionService);

    private final TaskRepository dbTaskRepository = new TaskDBRepositoryImpl(connectionService);

    private final ProjectService projectService = new ProjectServiceImpl(mbProjectRepository);

    private final TaskService taskService = new TaskServiceImpl(dbTaskRepository);

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService);

    private final SessionRepository sessionRepository = new SessionRepositoryImpl();

    private final SessionService sessionService = new SessionServiceImpl(sessionRepository);

    private final UserService userService = new UserServiceImpl(mbUserRepository, sessionService);

    private final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService);

    private final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    private final AdminService adminService = new AdminServiceImpl(
            projectService,
            userService,
            taskService,
            dbProjectRepository,
            dbUserRepository,
            dbTaskRepository
    );

    private final AdminEndPoint adminEndPoint = new AdminEndPointImpl(adminService);

    @Override
    public ConnectionService getConnectionService() {
        return connectionService;
    }

    @Override
    public SessionService getSessionService() {
        return sessionService;
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
    public UserService getUserService() {
        return this.userService;
    }

    public void init() {
        Endpoint.publish("http://localhost:8080/projectEndPoint?wsdl", projectEndPoint);
        Endpoint.publish("http://localhost:8080/taskEndPoint?wsdl", taskEndPoint);
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl", userEndPoint);
        Endpoint.publish("http://localhost:8080/adminEndPoint?wsdl", adminEndPoint);
    }

}
