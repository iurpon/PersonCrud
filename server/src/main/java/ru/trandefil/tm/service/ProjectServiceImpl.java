package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.util.EMFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final UserService userService;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserService userService) {
        this.projectRepository = projectRepository;
        this.userService = userService;
    }

    @Override
    public Project save(@NonNull String userId, @NonNull String name, @NonNull String description) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
//        final User ref = userService.getRefById(userId);
        User user = userService.getById(userId);
        final Project created = new Project(null, name, description, user);
        final Project saved = projectRepository.save(created, em);
        em.getTransaction().commit();
        em.close();
        return saved;
    }

    @Override
    public Project update(Project project) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Project updated = projectRepository.save(project,em);
        em.getTransaction().commit();
        em.close();
        return updated;
    }

    @Override
    public List<Project> getAll(@NonNull String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final List<Project> projects = projectRepository.getAll(userId, em);
        em.close();
        return projects;
    }

    @Override
    public List<Project> getAll() {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final List<Project> projects = projectRepository.getAll(em);
        em.close();
        return projects;
    }

    @Override
    public Project getById(@NonNull String id, @NonNull String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Project project = projectRepository.getById(userId, id, em);
        em.close();
        return project;
    }

    @Override
    public void delete(@NonNull String userId, @NonNull Project project) {
/*        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        projectRepository.delete(project,em);
        em.getTransaction().commit();
        em.close();*/
    }

    @Override
    public boolean deleteByName(@NonNull String userId, @NonNull String projectName) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final boolean result = projectRepository.deleteByName(userId, projectName, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    @Override
    public Project getByName(@NonNull String userId, @NonNull String projectName) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Project project = projectRepository.getByName(userId, projectName, em);
        em.close();
        return project;
    }

}
