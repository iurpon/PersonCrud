package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static org.junit.Assert.*;

public class DataJsonSaveTest {

    @Test
    public void execute() {
        final ProjectService projectService = new ProjectServiceImpl(new ProjectRepositoryImpl());
        List<Project> projects = projectService.getAll();
        try (OutputStream outputStream = new FileOutputStream("data.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(projects);
            outputStream.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}