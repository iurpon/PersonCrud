package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepositoryImpl;
import ru.trandefil.tm.service.ProjectServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataXmlSaveCommandTest {

    @Test
    public void execute() throws IOException {
        final ProjectService projectService = new ProjectServiceImpl(new ProjectRepositoryImpl());
        final List<Project> projectList = projectService.getAll();
        final ObjectMapper objectMapper = new XmlMapper();
        final String xml = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(projectList);
        Files.write(Paths.get("data.xml"), xml.getBytes());
        System.out.println(xml);
    }
}