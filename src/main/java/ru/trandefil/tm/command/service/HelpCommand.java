package ru.trandefil.tm.command.service;

import ru.trandefil.tm.api.ServiceLocator;
import ru.trandefil.tm.command.AbstractCommand;

public class HelpCommand extends AbstractCommand {

    public HelpCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public HelpCommand() {
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "return list of commands";
    }

    @Override
    public void execute() {
        getServiceLocator().getCommandMap().keySet().stream()
                .sorted()
                .forEach(s -> System.out.format("%s ( %s ) \n"
                        , s, getServiceLocator().getCommandMap().get(s).description()));
    }

    @Override
    public boolean secure() {
        return false;
    }

}
