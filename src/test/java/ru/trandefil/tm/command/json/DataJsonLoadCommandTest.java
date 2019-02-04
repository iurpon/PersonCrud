package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ru.trandefil.tm.entity.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class DataJsonLoadCommandTest {

    @Test
    public void execute() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = new String(Files.readAllBytes(Paths.get("data.json")));
            List<Project> projects = objectMapper.readValue(json,new TypeReference<List<Project>>(){});
            projects.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}