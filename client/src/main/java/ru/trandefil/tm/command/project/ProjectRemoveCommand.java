package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectRemoveCommand() {
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final Session session = getServiceLocator().getSession();
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final String removingProject = getNotNullString(terminalService,"enter project name to delete");
        projectEndPoint.deleteProjectByName(removingProject,session);

    }

    @Override
    public boolean secure() {
        return true;
    }

}
