package ru.trandefil.tm.api;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    TerminalService getTerminalService();

    void setLoggedUser(User loggedUser);

    User getLoggedUser();

    Map<String, AbstractCommand> getCommandMap();

}
