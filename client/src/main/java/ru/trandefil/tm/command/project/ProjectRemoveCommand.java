package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectRemoveCommand() {
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "remove project";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
