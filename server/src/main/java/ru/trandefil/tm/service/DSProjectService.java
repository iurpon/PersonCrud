package ru.trandefil.tm.service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;

import javax.inject.Inject;
import java.util.List;

@Transactional
public class DSProjectService implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Override
    public Project save(String userId, String name, String description) {
        return null;
    }

    @Override
    public List<Project> getAll(String userId) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project getById(String id, String userId) {
        return null;
    }

    @Override
    public void delete(String userId, Project project) {

    }

    @Override
    public boolean deleteByName(String userId, String projectName) {
        return false;
    }

    @Override
    public Project getByName(String userId, String projectName) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

}
