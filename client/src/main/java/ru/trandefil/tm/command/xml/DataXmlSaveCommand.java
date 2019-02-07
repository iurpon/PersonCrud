package ru.trandefil.tm.command.xml;

import ru.trandefil.tm.command.AbstractCommand;

public class DataXmlSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-save";
    }

    @Override
    public String description() {
        return "save object data to xml file";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
