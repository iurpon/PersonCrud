package ru.trandefil.tm.command.task;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.Session;
import ru.trandefil.tm.generated.Task;
import ru.trandefil.tm.generated.TaskDTO;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.service.TerminalService;
import ru.trandefil.tm.util.UserInputUtil;

public class TaskRemoveCommand extends AbstractCommand {

    public TaskRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskRemoveCommand() {
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "remove a project task";
    }

    @Override
    public void execute() {
        final TaskEndPoint taskEndPoint = getServiceLocator().getTaskEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String removingTask =
                UserInputUtil.getNotNullString(terminalService,"enter removing task name");
        final boolean removing = taskEndPoint.deleteTaskByName(removingTask,session);
        if(!removing){
            System.out.println("wrong task name.");
            return;
        }
        System.out.println(" deleted succesfully.");
    }

    @Override
    public boolean secure() {
        return true;
    }

}
