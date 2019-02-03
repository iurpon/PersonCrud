package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class ProjectRemoveCommand extends AbstractCommand {

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

    @Override
    public boolean secure() {
        return true;
    }

}
