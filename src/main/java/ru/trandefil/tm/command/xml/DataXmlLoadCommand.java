package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.ObjectFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
            ObjectFactory objectFactory = objectMapper.readValue(xmlString, ObjectFactory.class);
            printCollection(objectFactory.getProjectList());
            printCollection(objectFactory.getUserList());
            printCollection(objectFactory.getTaskList());
        } catch (IOException e) {
            System.out.println("is empty.");
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

    private <T> void printCollection(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        list.forEach(System.out::println);
    }

}
