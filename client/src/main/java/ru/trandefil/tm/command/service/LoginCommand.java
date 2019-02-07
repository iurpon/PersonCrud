package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class LoginCommand extends AbstractCommand {

    public LoginCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public LoginCommand() {
    }

    @Override
    public String command() {
        return "login";
    }

    @Override
    public String description() {
        return "login user into system";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return false;
    }

}
