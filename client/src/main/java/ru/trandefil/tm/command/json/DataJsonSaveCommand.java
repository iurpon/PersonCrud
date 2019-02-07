package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "convert object to json and save it to file.";
    }

    @Override
    public void execute() {

    }


    @Override
    public boolean secure() {
        return true;
    }

}
