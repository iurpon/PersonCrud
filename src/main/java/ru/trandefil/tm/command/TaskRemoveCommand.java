package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskRemoveCommand() {
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName =
                getNotNullString(terminalService, "Enter project name to remove task");
        final ProjectService projectService = getServiceLocator().getProjectService();
        final Project project = projectService.getByName(projectName);
        if (project == null) {
            System.out.println("Wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService, "Enter task name");
        final TaskService taskService = getServiceLocator().getTaskService();
        taskService.deleteByName(taskName);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
