package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

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
            String xml = new String(Files.readAllBytes(Paths.get("data.xml")));
            List<Project> projects = objectMapper.readValue(xml, new TypeReference<List<Project>>() {});
            projects.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
