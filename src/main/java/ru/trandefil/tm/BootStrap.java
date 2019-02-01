package ru.trandefil.tm;

import ru.trandefil.tm.command.AbstractCommand;
import ru.trandefil.tm.command.ProjectList;
import ru.trandefil.tm.entity.BaseEntity;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.repository.ProjectRepository;
import ru.trandefil.tm.service.ProjectService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootStrap {
    private final Map<String, AbstractCommand> commandMap = new HashMap<>();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final ProjectService projectService = new ProjectService(projectRepository);

    public void init() throws IOException {

        fillCommandMap();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                String s = reader.readLine();
                AbstractCommand abstractCommand = commandMap.get(s);
                if(abstractCommand == null){
                    System.out.println("Bad command.");
                    continue;
                }
                List<BaseEntity> projectList = abstractCommand.execute();
                projectList.forEach(System.out::println);
            }
        }
    }

    private void fillCommandMap() {
        commandMap.put("project-list",new ProjectList(projectService));
    }
}
