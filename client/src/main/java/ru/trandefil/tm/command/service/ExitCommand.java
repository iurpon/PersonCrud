package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ExitCommand() {
    }

    @Override
    public String command() {
        return "exit";
    }

    @Override
    public String description() {
        return "stop program execution";
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
