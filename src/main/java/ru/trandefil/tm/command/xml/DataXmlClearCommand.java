package ru.trandefil.tm.command.xml;

import ru.trandefil.tm.command.AbstractCommand;

import java.io.File;

public class DataXmlClearCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "delete file with xml data";
    }

    @Override
    public void execute() {
        File file = new File("data.xml");
        file.delete();
    }

    @Override
    public boolean secure() {
        return true;
    }
}
