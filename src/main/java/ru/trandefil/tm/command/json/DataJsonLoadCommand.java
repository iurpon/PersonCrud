package ru.trandefil.tm.command.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and covert to Object";
    }

    @Override
    public void execute() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = new String(Files.readAllBytes(Paths.get("data.json")));
            List<Project> projects = objectMapper.readValue(json,new TypeReference<List<Project>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return false;
    }

}
