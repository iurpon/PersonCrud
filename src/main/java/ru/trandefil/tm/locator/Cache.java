package ru.trandefil.tm.locator;

import ru.trandefil.tm.repository.AbstractRepository;
import ru.trandefil.tm.repository.ProjectRepository;
import ru.trandefil.tm.repository.TaskRepository;
import ru.trandefil.tm.service.AbstractService;
import ru.trandefil.tm.service.ProjectService;
import ru.trandefil.tm.service.TaskService;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private  Map<String, AbstractService> serviceMap = new HashMap<>();
    private  Map<String, AbstractRepository> repoMap = new HashMap<>();
    {
        repoMap.put("projectRepository",new ProjectRepository());
        repoMap.put("taskRepository",new TaskRepository());
        serviceMap.put("projectService",new ProjectService( repoMap.get("projectRepository")));
        serviceMap.put("taskService",new TaskService( repoMap.get("taskRepository")));
    }

    public AbstractService getService(String name){
        return serviceMap.get(name);
    }
}
