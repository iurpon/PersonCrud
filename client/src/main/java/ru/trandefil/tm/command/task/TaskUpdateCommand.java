package ru.trandefil.tm.command.task;


import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

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

    }

    @Override
    public boolean secure() {
        return true;
    }

}
