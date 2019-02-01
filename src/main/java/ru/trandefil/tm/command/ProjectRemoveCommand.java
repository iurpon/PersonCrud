package ru.trandefil.tm.command;

import ru.trandefil.tm.BootStrap;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;

import java.util.Scanner;

public class ProjectRemoveCommand  extends AbstractCommand {
    public ProjectRemoveCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plz enter project name you want to delete : ");
        String name = scanner.nextLine();
        ProjectService projectService = abstractServiceLocator.getProjectService();
        projectService.deleteByName(name);
    }
}
