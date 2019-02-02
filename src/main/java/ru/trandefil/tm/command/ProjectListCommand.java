package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;

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
        final ProjectService projectService = serviceLocator.getProjectService();
        final List<Project> projectList = projectService.getAll();
        projectList.forEach(System.out::println);
    }
}
