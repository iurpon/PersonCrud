package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and covert to Object";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
