package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static ru.trandefil.tm.util.FilterCollectionUtil.*;

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
    public void execute() {
/*        try (InputStream inputStream = new FileInputStream("data.bin")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Project[] projects = (Project[]) objectInputStream.readObject();
            User[] users = (User[]) objectInputStream.readObject();
            Task[] tasks = (Task[]) objectInputStream.readObject();
            printProjectCollection(Arrays.asList(projects),getServiceLocator().getLoggedUser());
            printUserCollection(Arrays.asList(users),getServiceLocator().getLoggedUser());
            printTaskCollection(Arrays.asList(tasks),getServiceLocator().getLoggedUser());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("is empty.");
        }*/
    }

    @Override
    public boolean secure() {
        return true;
    }

}
