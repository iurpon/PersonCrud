package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getAll(String userId, EntityManager em) {
        Query query = em.createQuery("select p from Project p left join p.user u where u.id = :userId");
        query.setParameter("userId", userId);
        List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public List<Project> getAll(EntityManager em) {
        Query query = em.createQuery("select p from Project p");
        List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public Project getByName(String userId, String projectName, EntityManager em) {
        Query query = em.createQuery("select p from Project p left join fetch p.user u where u.id = :userId and p.name = :name");
        query.setParameter("userId", userId);
        query.setParameter("name", projectName);
        Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project getById(String userId, String projectId, EntityManager em) {
        Query query = em.createQuery("select p from Project p where p.user.id = :userId and p.id = :projectId");
        query.setParameter("userId", userId);
        query.setParameter("projectId", projectId);
        Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project save(Project project, EntityManager em) {
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            em.persist(project);
            return project;
        }
        return em.merge(project);
    }

    @Override
    public void delete(Project project, EntityManager em) {
        em.remove(project);
    }

    @Override
    public boolean deleteByName(String userId, String projectName, EntityManager em) {
        Query query = em.createQuery("delete from Project p where p.user.id = :userId and p.name = :projectName");
        int result = query.executeUpdate();
        return result != 0;
    }

}
