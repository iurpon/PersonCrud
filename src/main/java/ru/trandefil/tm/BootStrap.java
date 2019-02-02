package ru.trandefil.tm;

import ru.trandefil.tm.command.*;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepository;
import ru.trandefil.tm.repository.UserRepository;
import ru.trandefil.tm.repository.inMemory.UserRepositoryImpl;
import ru.trandefil.tm.service.*;
import ru.trandefil.tm.service.inMemory.UserServiceImpl;
import ru.trandefil.tm.util.UserLoginUtil;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BootStrap  implements ServiceLocator {
    private  final Map<String, AbstractCommand> commandMap = new HashMap<>();
     {
        commandMap.put("project-list",new ProjectListCommand(this));
        commandMap.put("project-create",new ProjectCreateCommand(this));
        commandMap.put("project-remove",new ProjectRemoveCommand(this));
        commandMap.put("project-update",new ProjectUpdateCommand(this));
        commandMap.put("task-list",new TaskListCommand(this));
        commandMap.put("task-create",new TaskCreateCommand(this));
        commandMap.put("task-remove",new TaskRemoveCommand(this));
        commandMap.put("task-update",new TaskUpdateCommand(this));
        commandMap.put("user-list",new UserListCommand(this));
        commandMap.put("user-create",new UserCreateCommand(this));
        commandMap.put("user-delete",new UserDeleteCommand(this));
        commandMap.put("user-update",new UserUpdateCommand(this));
    }

    private ProjectRepositoryImpl projectRepository = new ProjectRepositoryImpl();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository);
    private TaskService taskService = new TaskService(taskRepository);
    private TerminalService terminalService = new TerminalService(new Scanner(System.in));
    private UserRepository userRepository = new UserRepositoryImpl();
    private UserService userService = new UserServiceImpl(userRepository);



    public void init() {
        UserLoginUtil.login(userService,terminalService);
        System.out.println("enter help to see commands & exit to stop program ");
            while(true){
                String s = terminalService.nextLine();
                if("help".equals(s)){
                    commandMap.keySet().forEach(System.out::println);
                    continue;
                }
                if("exit".equals(s)){
                    break;
                }
                AbstractCommand abstractCommand = commandMap.get(s);
                if(abstractCommand == null){
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
    public UserService getUserService(){ return this.userService;}


}
