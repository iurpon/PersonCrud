package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.service.TerminalService;

import java.util.UUID;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        final TerminalService scanner = getServiceLocator().getTerminalService();
        final String name = getNotNullString(scanner, "Enter project name : ");
        final String description = getNotNullString(scanner, "Enter project description");
        final Project newProject = new Project(UUID.randomUUID().toString(), name, description);
        final ProjectService projectService = getServiceLocator().getProjectService();
        projectService.save(newProject);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
