package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class UserDeleteCommand extends AbstractCommand {

    public UserDeleteCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserDeleteCommand() {
    }

    @Override
    public String command() {
        return "user-delete";
    }

    @Override
    public String description() {
        return "delete user";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
