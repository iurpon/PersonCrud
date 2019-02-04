package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "convert object to json and save it to file.";
    }

    @Override
    public void execute() {
        final ProjectService projectService = getServiceLocator().getProjectService();
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

    @Override
    public boolean secure() {
        return false;
    }

}
