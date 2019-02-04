package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;

import java.io.File;

public class DataBinClearCommand extends AbstractCommand {
    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "clear-data-file";
    }

    @Override
    public void execute() {
        File file = new File("data.bin");
        file.delete();
    }

    @Override
    public boolean secure() {
        return true;
    }
}
