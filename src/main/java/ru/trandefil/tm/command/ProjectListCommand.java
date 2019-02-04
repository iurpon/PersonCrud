package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        final ProjectService projectService = getServiceLocator().getProjectService();
        final List<Project> projectList = projectService.getAll();
        projectList.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
