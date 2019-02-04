package ru.trandefil.tm;

import org.reflections.Reflections;
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
    public Map<String, AbstractCommand> getCommandMap() {
        return commandMap;
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

    private void getClassesAndFillMap(String packageInfo){
        Reflections refilections = new Reflections(packageInfo);
        Set<Class<? extends AbstractCommand>> subTypes = refilections.getSubTypesOf(AbstractCommand.class);
        subTypes.forEach(cl -> {
            try {
                AbstractCommand ac = cl.newInstance();
                ac.setServiceLocator(this);
                commandMap.put(ac.command(),ac);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public void init() {
        getClassesAndFillMap("ru.trandefil.tm.command");
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
