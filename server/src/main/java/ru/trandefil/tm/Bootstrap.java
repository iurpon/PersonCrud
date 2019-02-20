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

public class Bootstrap {


    private final SqlSessionService sqlSessionService = new SqlSessionServiceImpl();

    private final ProjectService projectService = new ProjectServiceImpl(sqlSessionService);

    private final TaskService taskService = new TaskServiceImpl(sqlSessionService);

    private final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService);

    private final SessionRepository sessionRepository = new SessionRepositoryImpl();

    private final SessionService sessionService = new SessionServiceImpl(sessionRepository);

    private final UserService userService = new UserServiceImpl(sessionService,sqlSessionService);

    private final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService);

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
