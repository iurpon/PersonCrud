package ru.trandefil.tm;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.ProjectCreateCommand;
import ru.trandefil.tm.command.ProjectListCommand;
import ru.trandefil.tm.command.ProjectRemoveCommand;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.repository.ProjectRepository;
import ru.trandefil.tm.repository.TaskRepository;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BootStrap  implements AbstractServiceLocator {
    private  final Map<String, AbstractCommand> commandMap = new HashMap<>();
     {
        commandMap.put("project-list",new ProjectListCommand(this));
        commandMap.put("project-create",new ProjectCreateCommand(this));
        commandMap.put("project-remove",new ProjectRemoveCommand(this));
    }

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository);
    private TaskService taskService = new TaskService(taskRepository);


    public void init() throws IOException {
        System.out.println("enter help to see commands ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                String s = reader.readLine();
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
    }

    @Override
    public ProjectService getProjectService() {
        return this.projectService;
    }

    @Override
    public TaskService getTaskService() {
        return this.taskService;
    }
}
