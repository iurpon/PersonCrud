package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;

import java.util.Scanner;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(AbstractServiceLocator abstractServiceLocator) {
        super(abstractServiceLocator);
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
        Scanner scanner = abstractServiceLocator.getScanner();
        System.out.println("you are trying to update project :");
        System.out.println("plz enter project name :");
        String projectName = scanner.nextLine();
        ProjectService projectService = abstractServiceLocator.getProjectService();
        Project project = projectService.getByName(projectName);
        if(project == null){
            System.out.println("wrong project name");
         }else{
            System.out.println("enter new project name");
            String newName = scanner.nextLine();
            System.out.println("enter new project description");
            String newDescription = scanner.nextLine();
            Project newProject = new Project(project.getId(),newName,newDescription);
            projectService.delete(project);
            projectService.save(newProject);
        }
    }
}
