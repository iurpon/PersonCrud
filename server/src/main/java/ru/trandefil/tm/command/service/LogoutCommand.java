package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class LogoutCommand extends AbstractCommand {

    public LogoutCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public LogoutCommand() {
    }

    @Override
    public String command() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout user from system.";
    }

    @Override
    public void execute() {
        getServiceLocator().setLoggedUser(null);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
