package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
            printProjectCollection(objectFactory.getProjectList(), getServiceLocator().getLoggedUser());
            printUserCollection(objectFactory.getUserList(), getServiceLocator().getLoggedUser());
            printTaskCollection(objectFactory.getTaskList(), getServiceLocator().getLoggedUser());
        } catch (IOException e) {
            System.out.println("is empty.");
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
