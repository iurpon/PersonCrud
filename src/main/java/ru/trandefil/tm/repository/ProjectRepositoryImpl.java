package ru.trandefil.tm.repository;

import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.trandefil.tm.repository.UserRepositoryImpl.USER;
import static ru.trandefil.tm.repository.UserRepositoryImpl.ADMIN;

public class ProjectRepositoryImpl implements ProjectRepository {

    public static final Project PROJECT1
            = new Project(UUIDUtil.getUniqueString(), "simpleProject1", "no description1",ADMIN);

    public static final Project PROJECT2
            = new Project(UUIDUtil.getUniqueString(), "simpleProject2", "no description2",ADMIN);

    public static final Project PROJECT3
            = new Project(UUIDUtil.getUniqueString(), "simpleProject3", "no description3",USER);

    private Map<String, Project> projects = new HashMap<>();

    {
        projects.put(PROJECT1.getName(), PROJECT1);
        projects.put(PROJECT2.getName(), PROJECT2);
        projects.put(PROJECT3.getName(), PROJECT3);
    }

    @Override
    public Project save(Project project) {
        projects.put(project.getName(), project);
        return project;
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public Project getByName(String name) {
        return projects.get(name);
    }

    @Override
    public void delete(Project project) {
        projects.remove(project.getName());
    }

    @Override
    public void deleteByName(String projectName) {
        projects.remove(projectName);
    }

}
