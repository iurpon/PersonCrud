package ru.trandefil.tm.command.project;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Project;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

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
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final String updatedName = getNotNullString(terminalService,"enter updated project name");
        final Project updating = projectEndPoint.getProjectByName(updatedName,session);
        if(updating == null){
            return;
        }
        final String newName = getNotNullString(terminalService,"enter new project name");
        final String newDesc = getNotNullString(terminalService,"enter new description name");
        updating.setName(newName);
        updating.setDescription(newDesc);
        projectEndPoint.updateProject(updating,session);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
