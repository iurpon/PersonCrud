package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.command.ObjectFactory;
import ru.trandefil.tm.entity.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class DataJsonLoadCommandTest {

    @Test
    public void execute() throws IOException {

            String xmlString = new String(Files.readAllBytes(Paths.get("data.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectFactory objectFactory = objectMapper.readValue(xmlString,ObjectFactory.class);
            objectFactory.getProjectList().forEach(System.out::println);
//        objectFactory.getTaskList().forEach(System.out::println);
            objectFactory.getUserList().forEach(System.out::println);
    }
}