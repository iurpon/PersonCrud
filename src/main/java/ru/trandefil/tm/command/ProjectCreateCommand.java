package ru.trandefil.tm.command;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.locator.AbstractServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TerminalService;
import static ru.trandefil.tm.util.ValidateUserInput.*;


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
        TerminalService scanner = abstractServiceLocator.getTermanalService();
        String name = getNotNullString(scanner,"Enter project name : ");
        String description = getNotNullString(scanner,"Enter project description");
        Project newProject = new Project(UUID.randomUUID().toString(),name,description);
        ProjectService projectService = abstractServiceLocator.getProjectService();
        projectService.save(newProject);

    }
}
