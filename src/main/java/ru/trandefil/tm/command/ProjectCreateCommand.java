package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;

import java.util.Scanner;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
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
        Scanner scanner = abstractServiceLocator.getScanner();
        System.out.println("Plz enter the project name :");
        String name = scanner.nextLine();
        System.out.println("Plz enter the project description");
        String description = scanner.nextLine();
        Project newProject = new Project(UUID.randomUUID().toString(),name,description);
        ProjectService projectService = abstractServiceLocator.getProjectService();
        projectService.save(newProject);

    }
}
