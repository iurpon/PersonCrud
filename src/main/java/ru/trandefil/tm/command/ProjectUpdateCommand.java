package ru.trandefil.tm.command;


import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.inMemory.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;


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
        final TerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("you are trying to update project :");
        final String projectName = getNotNullString(terminalService, "plz enter project name :");
        final ProjectService projectService = serviceLocator.getProjectService();
        final Project project = projectService.getByName(projectName);
        if (project == null) {
            System.out.println("wrong project name");
            return;
        }
        final String newName = getNotNullString(terminalService, "enter new project name");
        final String newDescription = getNotNullString(terminalService, "enter new project description");
        final Project newProject = new Project(project.getId(), newName, newDescription);
        projectService.delete(project);
        projectService.save(newProject);

    }
}
