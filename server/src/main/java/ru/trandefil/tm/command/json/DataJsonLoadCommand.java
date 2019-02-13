package ru.trandefil.tm.command.json;

import ru.trandefil.tm.command.AbstractCommand;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
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
    @WebMethod
    public void execute() {

    }

    @Override
    public boolean secure() {
        return true;
    }

}
