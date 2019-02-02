package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.inMemory.TerminalService;

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
        final TerminalService scanner = serviceLocator.getTerminalService();
        final String name = getNotNullString(scanner, "Enter project name : ");
        final String description = getNotNullString(scanner, "Enter project description");
        final Project newProject = new Project(UUID.randomUUID().toString(), name, description);
        final ProjectService projectService = serviceLocator.getProjectService();
        projectService.save(newProject);

    }
}
