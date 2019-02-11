package ru.trandefil.tm.command;

import org.junit.Before;
import ru.trandefil.tm.api.*;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.SessionRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.SessionServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import static ru.trandefil.tm.command.ProjectCommandTestData.*;
import static ru.trandefil.tm.command.UserCommandTestData.*;
import static ru.trandefil.tm.command.TaskCommandTestData.*;

public class AbstractCommandTest {

    protected UserRepository userRepository = new UserRepositoryImpl();

    protected TaskRepository taskRepository = new TaskRepositoryImpl();

    protected ProjectRepository projectRepository = new ProjectRepositoryImpl();

    protected SessionRepository sessionRepository = new SessionRepositoryImpl();

    protected SessionService sessionService = new SessionServiceImpl(sessionRepository);

    protected UserService userService = new UserServiceImpl(userRepository,sessionService);

    protected TaskService taskService = new TaskServiceImpl(taskRepository);

    protected ProjectService projectService = new ProjectServiceImpl(projectRepository);

    @Before
    public void setUp() throws Exception {
/*        projectRepository.clear();
        projectService.save(PROJECT1);
        projectService.save(PROJECT2);
        projectService.save(PROJECT3);
        userRepository.clear();
        userService.save(USER);
        userService.save(ADMIN);
        taskRepository.clear();
        taskService.save(TASK1);
        taskService.save(TASK2);
        taskService.save(TASK3);*/
    }

}
