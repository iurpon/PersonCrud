package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Project;
import ru.trandefil.tm.generated.ProjectDTO;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.service.TerminalService;

import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectCreateCommand() {
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
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName = getNotNullString(terminalService, "enter project name");
        final String projectDesc = getNotNullString(terminalService, "enter project desсription");
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        ProjectDTO project = projectEndPoint.saveProject(projectName, projectDesc, session);
        if(project != null){
            System.out.println("saved succesfully");
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
