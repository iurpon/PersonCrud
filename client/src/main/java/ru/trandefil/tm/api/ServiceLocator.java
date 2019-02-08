package ru.trandefil.tm.api;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.generated.ProjectEndPoint;
import ru.trandefil.tm.generated.TaskEndPoint;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    TerminalService getTerminalService();

    Map<String, AbstractCommand> getCommandMap();

    ProjectEndPoint getProjectEndPoint();

    TaskEndPoint getTaskEndPoint();

    UserEndPoint getUserEndPoint();

}
