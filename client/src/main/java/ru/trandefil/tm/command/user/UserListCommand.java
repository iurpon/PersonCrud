package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class UserListCommand extends AbstractCommand {

    public UserListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserListCommand() {
    }

    @Override
    public String command() {
        return "user-list";
    }

    @Override
    public String description() {
        return "show all users";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
