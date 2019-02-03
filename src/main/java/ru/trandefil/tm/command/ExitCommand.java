package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
