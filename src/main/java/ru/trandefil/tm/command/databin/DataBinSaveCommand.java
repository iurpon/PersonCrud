package ru.trandefil.tm.command.databin;

import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.entity.Project;

import java.io.*;
import java.util.List;

public class DataBinSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-bin-save";
    }

    @Override
    public String description() {
        return "store data to bin file";
    }

    @Override
    public void execute() {
        try(OutputStream outputStream = new FileOutputStream("data.bin")){
            final ProjectService projectService = getServiceLocator().getProjectService();
            List<Project> projectList = projectService.getAll();
            Project[] projectArray = new Project[projectList.size()];
            projectList.toArray(projectArray);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.bin"));
            objectOutputStream.writeObject(projectArray);
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
