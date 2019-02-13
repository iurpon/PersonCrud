package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.trandefil.tm.repository.UserRepositoryImpl.ADMIN;
import static ru.trandefil.tm.repository.UserRepositoryImpl.USER;

public class ProjectRepositoryImpl implements ProjectRepository {

    private Map<String, Project> projects = new HashMap<>();


/*    public static final Project PROJECT1
            = new Project(UUIDUtil.getUniqueString(), "simpleProject1", "no description1", ADMIN.getId());

    public static final Project PROJECT2
            = new Project(UUIDUtil.getUniqueString(), "simpleProject2", "no description2", ADMIN.getId());

    public static final Project PROJECT3
            = new Project(UUIDUtil.getUniqueString(), "simpleProject3", "no description3", USER.getId());

    {
        projects.put(PROJECT1.getId(), PROJECT1);
        projects.put(PROJECT2.getId(), PROJECT2);
        projects.put(PROJECT3.getId(), PROJECT3);
    }*/

    @Override
    public void clear() {
        projects.clear();
    }

    @Override
    public Project save(final Project project) {
        projects.put(project.getId(), project);
        return project;
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projects.values());
    }

    @Override
    public Project getById(final String id) {
        return projects.get(id);
    }

    @Override
    public Project getByName(String projectName) {
        return getAll().stream()
                .filter(p -> p.getName().equals(projectName))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(final Project project) {
        projects.remove(project.getId());
    }

    @Override
    public void deleteByName(final String projectName) {
        final Project project = getByName(projectName);
        if(project == null){
            return;
        }
        delete(project);
    }

}
