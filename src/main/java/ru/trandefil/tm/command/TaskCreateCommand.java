package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.inMemory.ProjectServiceImpl;
import ru.trandefil.tm.service.inMemory.TaskServiceImpl;
import ru.trandefil.tm.service.inMemory.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.*;

import java.util.Date;
import java.util.UUID;

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
        final TerminalService terminalService = serviceLocator.getTerminalService();

        final String projectName =
                getNotNullString(terminalService, "enter project name to add new task :");
        final ProjectServiceImpl projectService = serviceLocator.getProjectService();
        final Project project = projectService.getByName(projectName);
        if (project == null) {
            System.out.println("Wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService, "Enter task name");
        final String taskDesc = getNotNullString(terminalService, "Enter task description");
        final Date taskBegin = getDate(terminalService, "task start ");
        Date taskEnd = null;
        if (taskBegin != null) {
            taskEnd = getDate(terminalService, "task end");
        }

        final Task newTask = new Task(UUID.randomUUID().toString(), taskName, taskDesc, taskBegin, taskEnd, project);
        final TaskServiceImpl taskService = serviceLocator.getTaskService();
        taskService.save(newTask);

    }

}
