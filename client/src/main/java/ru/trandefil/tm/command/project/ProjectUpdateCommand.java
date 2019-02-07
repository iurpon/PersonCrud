package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectUpdateCommand() {
    }

    @Override
    public String command() {
        return "project-update";
    }

    @Override
    public String description() {
        return "update project";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
