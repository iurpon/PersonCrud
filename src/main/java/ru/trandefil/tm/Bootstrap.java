package ru.trandefil.tm;

import ru.trandefil.tm.api.*;
import ru.trandefil.tm.command.*;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.repository.TaskRepositoryImpl;
import ru.trandefil.tm.repository.UserRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;
import ru.trandefil.tm.service.TaskServiceImpl;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.service.UserServiceImpl;

import java.util.*;

public class Bootstrap implements ServiceLocator {

    private User loggedUser = null;

    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    private final ProjectService projectService = new ProjectServiceImpl(projectRepository);

    private final TaskService taskService = new TaskServiceImpl(taskRepository);

    private final TerminalService terminalService = new TerminalService(new Scanner(System.in));

    private final UserRepository userRepository = new UserRepositoryImpl();

    private final UserService userService = new UserServiceImpl(userRepository);

    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
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

    public void fillMap(AbstractCommand abstractCommand) {
        commandMap.put(abstractCommand.command(), abstractCommand);
    }

    public void initAbstractCommandMap() {
        List<AbstractCommand> abstractCommandList = new ArrayList<>();
        abstractCommandList.add(new ProjectListCommand(this));
        abstractCommandList.add(new ProjectCreateCommand(this));
        abstractCommandList.add(new ProjectRemoveCommand(this));
        abstractCommandList.add(new ProjectUpdateCommand(this));
        abstractCommandList.add(new TaskListCommand(this));
        abstractCommandList.add(new TaskCreateCommand(this));
        abstractCommandList.add(new TaskRemoveCommand(this));
        abstractCommandList.add(new TaskUpdateCommand(this));
        abstractCommandList.add(new UserListCommand(this));
        abstractCommandList.add(new UserCreateCommand(this));
        abstractCommandList.add(new UserDeleteCommand(this));
        abstractCommandList.add(new UserUpdateCommand(this));
        abstractCommandList.add(new HelpCommand(this, commandMap));
        abstractCommandList.add(new ExitCommand(this));
        abstractCommandList.add(new LoginCommand(this));
        abstractCommandList.add(new LogoutCommand(this));
        abstractCommandList.forEach(this::fillMap);
    }

    public void init() {
        initAbstractCommandMap();
        System.out.println("enter help to see commands.");
        while (true) {
            final String s = terminalService.nextLine();
            final AbstractCommand abstractCommand = commandMap.get(s);
            if (abstractCommand == null) {
                System.out.println("Bad command.");
                continue;
            }
            if(!abstractCommand.secure()){
                abstractCommand.execute();
                continue;
            }
            final AbstractCommand loginCommand = commandMap.get("login");
            loginCommand.execute();
            if(loggedUser == null){
                continue;
            }
            abstractCommand.execute();
        }
    }

}
