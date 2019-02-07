package ru.trandefil.tm.command.xml;

import ru.trandefil.tm.command.AbstractCommand;

public class DataXmlLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-load";
    }

    @Override
    public String description() {
        return "load xml data from file";
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }



}
