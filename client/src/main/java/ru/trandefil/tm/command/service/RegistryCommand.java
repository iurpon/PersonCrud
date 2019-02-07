package ru.trandefil.tm.command.service;

import ru.trandefil.tm.command.AbstractCommand;

public class RegistryCommand extends AbstractCommand {

    public RegistryCommand() {
    }

    @Override
    public String command() {
        return "registry";
    }

    @Override
    public String description() {
        return "registry new user";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return false;
    }

}
