package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class TaskListCommand extends AbstractCommand {

    public TaskListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskListCommand() {
    }

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "get all tasks from  a project";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
