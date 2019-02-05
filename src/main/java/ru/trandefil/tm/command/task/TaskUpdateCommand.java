package ru.trandefil.tm.command.task;


import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.service.TerminalService;

import java.util.Date;

import static ru.trandefil.tm.util.UserInputUtil.getDate;
import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskUpdateCommand() {
    }

    @Override
    public String command() {
        return "task-update";
    }

    @Override
    public String description() {
        return "update a project task";
    }

    @Override
    public void execute() {
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String taskName = getNotNullString(terminalService, "Enter task name for update : ");
        final TaskService taskService = getServiceLocator().getTaskService();
        final Task requestedTask = taskService.getByName(taskName);
        if(requestedTask == null && !requestedTask.getAssignee().equals(getServiceLocator().getLoggedUser())){
            System.out.println("wrong task name or no permission to delete task.");
            return;
        }
        final String newName = getNotNullString(terminalService, "Enter new task name");
        final String newDescription = getNotNullString(terminalService, "Enter new task description");
        final Date beginDate = getDate(terminalService, "begin date");
        Date endDate = null;
        if (beginDate != null) {
            endDate = getDate(terminalService, "end date");
        }
        final Task newTask =
                new Task(requestedTask.getId(), newName, newDescription, beginDate, endDate,
                        requestedTask.getProject(),requestedTask.getAssignee(),requestedTask.getExecuter());
        taskService.deleteByName(requestedTask.getName());
        taskService.save(newTask);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
