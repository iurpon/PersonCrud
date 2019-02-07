package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;

public class DataBinLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-load";
    }

    @Override
    public String description() {
        return "load data from bin file";
    }

    @Override
    public void execute() {}


    @Override
    public boolean secure() {
        return true;
    }

}
