package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "store data to bin file";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
