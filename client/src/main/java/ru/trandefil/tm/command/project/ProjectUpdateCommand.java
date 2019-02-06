package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectUpdateCommand() {
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        System.out.println("you are trying to update project : ");
        final String projectName = getNotNullString(terminalService, "plz enter project name : ");
        final ProjectService projectService = getServiceLocator().getProjectService();
        final Project project = projectService.getById(projectName);
        if (project == null && !project.getUser().equals(getServiceLocator().getLoggedUser())) {
            System.out.println("wrong project name or no permition to delete");
            return;
        }
        final String newName = getNotNullString(terminalService, "enter new project name");
        final String newDescription = getNotNullString(terminalService, "enter new project description");
        final Project newProject = new Project(project.getId(), newName, newDescription);
        newProject.setUser(getServiceLocator().getLoggedUser());
        projectService.delete(project);
        projectService.save(newProject);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
