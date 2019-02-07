package ru.trandefil.tm.command.user;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class UserUpdateCommand extends AbstractCommand {

    public UserUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserUpdateCommand() {
    }

    @Override
    public String command() {
        return "user-update";
    }

    @Override
    public String description() {
        return "update user";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
