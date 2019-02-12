package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.generated.ProjectEndPoint;

import java.util.List;
import java.util.stream.Collectors;

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
