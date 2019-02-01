package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.ValidateUserInput.*;

public class TaskRemoveCommand extends AbstractCommand {
    public TaskRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "remove a project task";
    }

    @Override
    public void execute() {
        TerminalService scanner = serviceLocator.getTerminalService();

        String projectName = getNotNullString(scanner,"Enter project name to remove task");
        ProjectService projectService = serviceLocator.getProjectService();
        Project project = projectService.getByName(projectName);
        if(project == null){
            System.out.println("Wrong project name");
            return;
        }else{
            String taskName = getNotNullString(scanner,"Enter task name");
            TaskService taskService = serviceLocator.getTaskService();
            taskService.deleteByName(taskName);
        }
    }
}
