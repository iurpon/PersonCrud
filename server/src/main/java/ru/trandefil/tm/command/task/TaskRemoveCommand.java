package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

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
/*        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String taskName = getNotNullString(terminalService, "Enter task name");
        final TaskService taskService = getServiceLocator().getTaskService();
        final Task requestedTask = taskService.getByName(taskName);
        if(requestedTask == null && !requestedTask.getAssignee().equals(getServiceLocator().getSession())){
            System.out.println("wrong task name or no permission to delete task.");
            return;
        }
        taskService.deleteByName(taskName);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
