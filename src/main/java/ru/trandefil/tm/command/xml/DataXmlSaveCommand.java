package ru.trandefil.tm.command.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataXmlSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-xml-save";
    }

    @Override
    public String description() {
        return "save object data to xml file";
    }

    @Override
    public void execute() {
        final ProjectService projectService = getServiceLocator().getProjectService();
        final List<Project> projectList = projectService.getAll();
        final ObjectMapper objectMapper = new XmlMapper();
        try {
            final String xml = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(projectList);
            Files.write(Paths.get("data.xml"), xml.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }
}
