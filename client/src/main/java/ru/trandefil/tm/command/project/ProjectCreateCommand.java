package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectCreateCommand() {
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public String description() {
        return "create new project";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
