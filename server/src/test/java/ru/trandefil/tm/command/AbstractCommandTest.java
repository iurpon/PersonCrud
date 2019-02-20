package ru.trandefil.tm.command;

import org.junit.Before;
import ru.trandefil.tm.api.*;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.SessionRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.SessionServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.UserServiceImpl;

import static ru.trandefil.tm.command.ProjectCommandTestData.*;
import static ru.trandefil.tm.command.TaskCommandTestData.*;
import static ru.trandefil.tm.command.UserCommandTestData.ADMIN;
import static ru.trandefil.tm.command.UserCommandTestData.USER;

public class AbstractCommandTest {

/*
    protected UserRepository userRepository = new UserRepositoryImpl();

    protected TaskRepository taskRepository = new TaskRepositoryImpl();

    protected ProjectRepository projectRepository = new ProjectRepositoryImpl();

    protected SessionRepository sessionRepository = new SessionRepositoryImpl();

    protected SessionService sessionService = new SessionServiceImpl(sessionRepository);

//    protected UserService userService = new UserServiceImpl(userRepository, sessionService);

    protected TaskService taskService = new TaskServiceImpl(taskRepository);

    protected ProjectService projectService = new ProjectServiceImpl(projectRepository);

    protected Session sessionAdmin = null;

    protected Session sessionUser = null;

    @Before
    public void setUp() {
        projectRepository.clear();
        projectRepository.save(PROJECT1);
        projectRepository.save(PROJECT2);
        projectRepository.save(PROJECT3);
        userRepository.clear();
        userRepository.save(USER);
        userRepository.save(ADMIN);
        taskRepository.clear();
        taskRepository.save(TASK1);
        taskRepository.save(TASK2);
        taskRepository.save(TASK3);
*/
/*        sessionAdmin = userService.getSession(ADMIN.getName(), ADMIN.getPassword());
        sessionUser = userService.getSession(USER.getName(), USER.getPassword());*//*

    }
*/

}
