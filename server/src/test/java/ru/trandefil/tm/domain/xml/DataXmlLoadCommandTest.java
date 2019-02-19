package ru.trandefil.tm.domain.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.domain.Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DataXmlLoadCommandTest {


    @Test
    public void execute() throws IOException {
        String xmlString = new String(Files.readAllBytes(Paths.get("data.xml")));
        ObjectMapper objectMapper = new XmlMapper();
        Domain objectFactory = objectMapper.readValue(xmlString, Domain.class);
        objectFactory.getProjects().forEach(System.out::println);
//        objectFactory.getTasks().forEach(System.out::println);
        objectFactory.getUsers().forEach(System.out::println);
    }

}