package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

import java.io.*;
import java.util.Arrays;

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
        try(InputStream inputStream = new FileInputStream("data.bin")){
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Project[] projects = (Project[]) objectInputStream.readObject();
            Arrays.stream(projects)
//                    .filter(project -> project.getUser().equals(getServiceLocator().getLoggedUser()))
                    .forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
