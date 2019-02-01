package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TerminalService;


public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        TerminalService scanner = serviceLocator.getTerminalService();
        System.out.println("you are trying to update project :");
        System.out.println("plz enter project name :");
        String projectName = scanner.nextLine();
        ProjectService projectService = serviceLocator.getProjectService();
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
