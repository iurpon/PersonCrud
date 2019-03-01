package ru.trandefil.tm.endpoint;

import org.junit.AfterClass;
import org.junit.Before;
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
import ru.trandefil.tm.util.EMFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

import static ru.trandefil.tm.TestData.*;

public abstract class AbstractEndPoint {

 /*   protected final UserRepository userRepository = new UserRepositoryImpl();

    protected final SessionRepository sessionRepository = new SessionRepositoryImpl();

    protected final UserService userService = new UserServiceImpl(userRepository, sessionRepository);

    protected final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    protected final ProjectService projectService = new ProjectServiceImpl(projectRepository, userService);

    protected final TaskRepository taskRepository = new TaskRepositoryImpl();

    protected final TaskService taskService = new TaskServiceImpl(taskRepository);

    protected final ProjectEndPoint projectEndPoint = new ProjectEndPointImpl(projectService, userService);

    protected final TaskEndPoint taskEndPoint = new TaskEndPointImpl(taskService, projectService, userService);

    protected final UserEndPoint userEndPoint = new UserEndPointImpl(userService);

    protected final AdminService adminService = new AdminServiceImpl(
            projectService,
            userService,
            taskService);

    protected final AdminEndPoint adminEndPoint = new AdminEndPointImpl(adminService);

    protected final Logger logger = Logger.getLogger(this.getClass().getName());

    private final static Logger LOGGER = Logger.getLogger(AbstractEndPoint.class.getName());

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("BEFORE CLASS @BEFORECLASS ---------------------------");
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.info("AFTER CLASS  @AFTERCLASS ------------------------------");

    }

    @Before
    public void beforeEachTest() {
        LOGGER.info("BEFORE EACH TEST @BEFORE -------------------------------");

        taskRepository.clear(EMFactoryUtil.getEntityManager());
        LOGGER.info("task repository cleared-------------------------------------");
        projectRepository.clear(EMFactoryUtil.getEntityManager());
        sessionRepository.clear(EMFactoryUtil.getEntityManager());
        userRepository.clear(EMFactoryUtil.getEntityManager());

*//*        userRepository.saveOrUpdate(ADMIN, EMFactoryUtil.getEntityManager());
        userRepository.saveOrUpdate(USER, EMFactoryUtil.getEntityManager());



        projectRepository.save(PROJECT1_ADMIN, entityManagerFactory.createEntityManager());
        projectRepository.save(PROJECT1_USER, entityManagerFactory.createEntityManager());

        taskRepository.save(TASK1_ADMIN, entityManagerFactory.createEntityManager());
        taskRepository.save(TASK2_ADMIN, entityManagerFactory.createEntityManager());
        taskRepository.save(TASK1_USER, entityManagerFactory.createEntityManager());*//*

        userService.save(ADMIN);
        userService.save(USER);

        projectService.update(PROJECT1_ADMIN);
        projectService.update(PROJECT1_USER);

        taskService.save(ADMIN.getId(),TASK1_ADMIN);
        taskService.save(ADMIN.getId(),TASK2_ADMIN);
        taskService.save(USER.getId(),TASK1_USER);

    }
*/
}
