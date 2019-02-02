package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;
import ru.trandefil.tm.service.inMemory.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

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
        final TerminalService terminalService = serviceLocator.getTerminalService();

        final String projectName =
                getNotNullString(terminalService, "Enter project name to remove task");
        final ProjectService projectService = serviceLocator.getProjectService();
        final Project project = projectService.getByName(projectName);
        if (project == null) {
            System.out.println("Wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService, "Enter task name");
        final TaskService taskService = serviceLocator.getTaskService();
        taskService.deleteByName(taskName);

    }
}
