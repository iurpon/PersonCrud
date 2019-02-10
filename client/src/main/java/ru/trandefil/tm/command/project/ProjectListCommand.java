package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Project;

import java.util.List;

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
/*
        final List<Project> projectList = getServiceLocator().getProjectEndPoint().getAllProjects();
        projectList.forEach(System.out::println);*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
