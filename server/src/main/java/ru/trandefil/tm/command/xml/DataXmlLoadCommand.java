package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.trandefil.tm.util.FilterCollectionUtil.*;

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
        try {
            ObjectMapper objectMapper = new XmlMapper();
            String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
            Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
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
