package ru.trandefil.tm.endpoint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import ru.trandefil.tm.api.*;
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

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public abstract class AbstractEndPoint {

    protected static EntityManagerFactory entityManagerFactory = null;

    protected final UserRepository userRepository = new UserRepositoryImpl();

    protected final SessionRepository sessionRepository = new SessionRepositoryImpl();

    protected final UserService userService = new UserServiceImpl(userRepository,sessionRepository);

    protected final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    protected final ProjectService projectService = new ProjectServiceImpl(projectRepository, userService);

    protected final TaskRepository taskRepository = new TaskRepositoryImpl();

    protected final TaskService taskService = new TaskServiceImpl(taskRepository);

    protected final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService,userService);

    protected final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService,projectService,userService);

    protected final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    protected final AdminService adminService = new AdminServiceImpl(
            projectService,
            userService,
            taskService);

    protected final AdminEndPoint adminEndPoint = new AdminEndPointImpl(adminService);

    protected final Logger logger = Logger.getLogger(this.getClass().getName());

    @BeforeClass
    public static void beforeClass(){
        entityManagerFactory  = Persistence.createEntityManagerFactory("entityManager");
    }

    @AfterClass
    public static void afterClass(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }

}
