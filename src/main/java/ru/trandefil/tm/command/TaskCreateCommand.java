package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.service.TerminalService;

import java.util.Date;
import java.util.UUID;

import static ru.trandefil.tm.util.UserInputUtil.getDate;
import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public AbstractCommand getInstance() {
        return new TaskCreateCommand(getServiceLocator());
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName =
                getNotNullString(terminalService, "enter project name to add new task :");
        final ProjectService projectService = getServiceLocator().getProjectService();
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
        final TaskService taskService = getServiceLocator().getTaskService();
        taskService.save(newTask);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
