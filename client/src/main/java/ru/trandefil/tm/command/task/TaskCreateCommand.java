package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.*;
import ru.trandefil.tm.service.TerminalService;

import java.util.Date;

import static ru.trandefil.tm.util.UserInputUtil.getDate;
import static ru.trandefil.tm.util.UserInputUtil.getNotNullString;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskCreateCommand() {
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create new task for project";
    }

    @Override
    public void execute() {
        final TaskEndPoint taskEndPoint = getServiceLocator().getTaskEndPoint();
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "name of task executer user");
        final User executer = userEndPoint.getUserByName(userName, session);
        if (executer == null) {
            System.out.println("wrong user name.");
            return;
        }
        final String projectName = getNotNullString(terminalService,"name of project");
        final Project updating = projectEndPoint.getProjectByName(projectName,session);
        if(updating == null){
            System.out.println("wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService,"enter task name");
        final String taskDesc = getNotNullString(terminalService,"enter task description");
        final Date startDate = getDate(terminalService,"enter task start date");
        final Date endDate = getDate(terminalService,"enter task end date");
//        taskEndPoint


    }

    @Override
    public boolean secure() {
        return true;
    }

}
