package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;



import java.util.Date;
import java.util.UUID;

import static ru.trandefil.tm.util.ValidateUserInput.getDate;
import static ru.trandefil.tm.util.ValidateUserInput.getNotNullString;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create new task for project";
    }

    @Override
    public void execute() {
        TerminalService scanner = serviceLocator.getTerminalService();
        System.out.println("enter project name to add new task :");
        String projectName = scanner.nextLine();
        ProjectService projectService = serviceLocator.getProjectService();
        Project project = projectService.getByName(projectName);
        if(project == null){
            System.out.println("Wrong project name");
            return;
        }else{
            String taskName = getNotNullString(scanner,"Enter task name");
            String taskDesc = getNotNullString(scanner,"Enter task description");
            Date taskBegin = getDate(scanner,"task start ");
            Date taskEnd = getDate(scanner,"task end");
            Task newTask = new Task(UUID.randomUUID().toString(),taskName,taskDesc,taskBegin,taskEnd,project);
            TaskService taskService = serviceLocator.getTaskService();
            taskService.save(newTask);
        }
    }

}
