package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.command.Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataXmlLoadCommandTest {

    @Test
    public void execute() throws IOException {
        String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
        ObjectMapper objectMapper = new XmlMapper();
        Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
        objectFactory.getProjectList().forEach(System.out::println);
//        objectFactory.getTaskList().forEach(System.out::println);
        objectFactory.getUserList().forEach(System.out::println);
    }
}