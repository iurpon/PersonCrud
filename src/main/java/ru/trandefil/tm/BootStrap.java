package ru.trandefil.tm;

import ru.trandefil.tm.command.*;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.repository.ProjectRepository;
import ru.trandefil.tm.repository.TaskRepository;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BootStrap  implements AbstractServiceLocator {
    private  final Map<String, AbstractCommand> commandMap = new HashMap<>();
     {
        commandMap.put("project-list",new ProjectListCommand(this));
        commandMap.put("project-create",new ProjectCreateCommand(this));
        commandMap.put("project-remove",new ProjectRemoveCommand(this));
        commandMap.put("project-update",new ProjectUpdateCommand(this));
        commandMap.put("task-list",new TaskListCommand(this));
        commandMap.put("task-create",new TaskCreateCommand(this));
    }

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository);
    private TaskService taskService = new TaskService(taskRepository);
    public  Scanner scanner = new Scanner(System.in);


    public void init() {
        System.out.println("enter help to see commands ");

            while(true){
                String s = scanner.nextLine();
                if("help".equals(s)){
                    commandMap.keySet().forEach(System.out::println);
                    continue;
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
    public Scanner getScanner() {
        return scanner;
    }


}
