package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.*;
import java.util.List;

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
