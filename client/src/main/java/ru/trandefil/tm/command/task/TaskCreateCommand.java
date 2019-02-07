package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskCreateCommand() {
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

    }

    @Override
    public boolean secure() {
        return true;
    }

}
