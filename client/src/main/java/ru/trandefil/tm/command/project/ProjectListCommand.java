package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectListCommand() {
    }

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "show all created projects";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
