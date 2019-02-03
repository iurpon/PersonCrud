package ru.trandefil.tm;

import ru.trandefil.tm.api.*;
import ru.trandefil.tm.command.*;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.service.UserServiceImpl;
import ru.trandefil.tm.util.UserLoginUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap implements ServiceLocator {

    final private ProjectRepository projectRepository = new ProjectRepositoryImpl();
    final private TaskRepository taskRepository = new TaskRepositoryImpl();
    final private ProjectService projectService = new ProjectServiceImpl(projectRepository);
    final private TaskService taskService = new TaskServiceImpl(taskRepository);
    final private TerminalService terminalService = new TerminalService(new Scanner(System.in));
    final private UserRepository userRepository = new UserRepositoryImpl();
    final private UserService userService = new UserServiceImpl(userRepository);

    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    {
        commandMap.put("project-list", new ProjectListCommand(this));
        commandMap.put("project-create", new ProjectCreateCommand(this));
        commandMap.put("project-remove", new ProjectRemoveCommand(this));
        commandMap.put("project-update", new ProjectUpdateCommand(this));
        commandMap.put("task-list", new TaskListCommand(this));
        commandMap.put("task-create", new TaskCreateCommand(this));
        commandMap.put("task-remove", new TaskRemoveCommand(this));
        commandMap.put("task-update", new TaskUpdateCommand(this));
        commandMap.put("user-list", new UserListCommand(this));
        commandMap.put("user-create", new UserCreateCommand(this));
        commandMap.put("user-delete", new UserDeleteCommand(this));
        commandMap.put("user-update", new UserUpdateCommand(this));
    }

    public void init() {
        UserLoginUtil.login(userService, terminalService);
        System.out.println("enter help to see commands & exit to stop program ");
        while (true) {
            String s = terminalService.nextLine();
            if ("help".equals(s)) {
                commandMap.keySet().forEach(System.out::println);
                continue;
            }
            if ("exit".equals(s)) {
                break;
            }
            AbstractCommand abstractCommand = commandMap.get(s);
            if (abstractCommand == null) {
                System.out.println("Bad command.");
                continue;
            }
            abstractCommand.execute();
        }
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
    public TerminalService getTerminalService() {
        return this.terminalService;
    }

    @Override
    public UserService getUserService() {
        return this.userService;
    }

}
