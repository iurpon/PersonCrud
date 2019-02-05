package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.ObjectFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static ru.trandefil.tm.util.FilterCollectionUtil.*;

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
    public void execute() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            ObjectFactory objectFactory = objectMapper.readValue(xmlString, ObjectFactory.class);
            printProjectCollection(objectFactory.getProjectList(), getServiceLocator().getLoggedUser());
            printUserCollection(objectFactory.getUserList(), getServiceLocator().getLoggedUser());
            printTaskCollection(objectFactory.getTaskList(), getServiceLocator().getLoggedUser());
        } catch (IOException e) {
            System.out.println("is empty.");
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
