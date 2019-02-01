package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    public static Map<String, Project> projects = new HashMap<>();
    static {
        projects.put("simpleProject",new Project("id","simpleProject","do nothing"));
    }
}
