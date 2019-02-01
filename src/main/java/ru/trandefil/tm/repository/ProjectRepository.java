package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository  implements AbstractRepository {
    public  Map<String, Project> projects = new HashMap<>();
    {
        projects.put("simpleProject",new Project("id","simpleProject","no description"));
    }
}
