package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class UserCreateCommand extends AbstractCommand {

    public UserCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserCreateCommand() {
    }

    @Override
    public String command() {
        return "user-create";
    }

    @Override
    public String description() {
        return "create new user";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
