package ru.trandefil.tm.command;
import ru.trandefil.tm.locator.ServiceLocator;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.ValidateUserInputUtil.*;



public class ProjectRemoveCommand  extends AbstractCommand {

    public ProjectRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
        final TerminalService terminalService = serviceLocator.getTerminalService();
        final String projectName = getNotNullString(terminalService,
                                                    "Plz enter project name you want to delete : ");
        final ProjectService projectService = serviceLocator.getProjectService();
        projectService.deleteByName(projectName);
    }

}
