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

    }

    @Override
    public boolean secure() {
        return true;
    }

}
