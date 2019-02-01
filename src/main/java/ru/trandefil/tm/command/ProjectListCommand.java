package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;


import java.util.List;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
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
        ProjectService projectService = abstractServiceLocator.getProjectService();
        List<Project> projectList = projectService.getAll();
        projectList.forEach(System.out::println);
    }
}
