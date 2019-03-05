package ru.trandefil.tm;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.repository.DSProjectRepository;
import ru.trandefil.tm.repository.DSSessionRepository;
import ru.trandefil.tm.repository.DSTaskRepository;
import ru.trandefil.tm.repository.DSUserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

@ApplicationScoped
public class Bootstrap {

    @Inject
    private DSUserRepository userRepository;

    @Inject
    private DSSessionRepository sessionRepository;

    @Inject
    private UserService userService;

    @Inject
    private DSProjectRepository projectRepository;

    @Inject
    private ProjectService projectService;

    @Inject
    private DSTaskRepository taskRepository;

    @Inject
    private TaskService taskService;

    @Inject
    private TaskEndPoint taskEndPoint;


    @Inject
    private ProjectEndPoint projectEndPoint;

    @Inject
    private UserEndPoint userEndPoint;

/*    @Inject
    private AdminService adminService;

    @Inject
    private AdminEndPoint adminEndPoint;*/

    public void init() {
        Endpoint.publish("http://localhost:8080/projectEndPoint?wsdl", projectEndPoint);
        Endpoint.publish("http://localhost:8080/taskEndPoint?wsdl", taskEndPoint);
        Endpoint.publish("http://localhost:8080/userEndPoint?wsdl", userEndPoint);
//        Endpoint.publish("http://localhost:8080/adminEndPoint?wsdl", adminEndPoint);
    }

}
