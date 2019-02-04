package ru.trandefil.tm.command;

import ru.trandefil.tm.api.ServiceLocator;

import java.util.Collection;
import java.util.Map;

public class HelpCommand extends AbstractCommand {

    @Override
    public AbstractCommand getInstance() {
        return new HelpCommand(getServiceLocator());
    }

    public HelpCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
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
       getServiceLocator().getCommandMap().values().forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return false;
    }

}
