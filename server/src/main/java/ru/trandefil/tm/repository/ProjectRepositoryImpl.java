package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.EMFactoryUtil;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class ProjectRepositoryImpl implements ProjectRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> getAll(@NonNull final String userId, @NonNull final EntityManager em) {
        final Query query = em.createQuery("select p from Project p left join p.user u where u.id = :userId");
        query.setParameter("userId", userId);
        final List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public List<Project> getAll(@NonNull final EntityManager em) {
        final Query query = em.createQuery("select p from Project p");
        final List<Project> projects = query.getResultList();
        return projects;
    }

    @Override
    public Project getByName(@NonNull final String userId, @NonNull final String name, @NonNull final EntityManager em) {
        logger.info("task repo getByName");
        final Query query = em.createQuery("select p from Project p where p.user.id = :userId and p.name = :name");
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        final Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project getById(@NonNull final String userId, @NonNull final String projectId, @NonNull final EntityManager em) {
        logger.info("task repo getById");
        final Query query = em.createQuery("select p from Project p where p.user.id = :userId and p.id = :projectId");
        query.setParameter("userId", userId);
        query.setParameter("projectId", projectId);
        final Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project save(@NonNull final Project project, @NonNull final EntityManager em) {
        logger.info("task repo save");
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            em.persist(project);
            return project;
        }
        return em.merge(project);
    }

    @Override
    public void delete(@NonNull final Project project, @NonNull final EntityManager em) {
        logger.info("task repo delete");
        em.remove(project);
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String projectName, @NonNull final EntityManager em) {
        logger.info("task repo deleteByName");
        Project project = getByName(userId, projectName, em);
        if (project == null) {
            logger.info("wrong project name.");
            return false;
        }
        delete(project, em);
        return true;
    }

    @Override
    public void clear() {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final Query query = em.createQuery("TRUNCATE TABLE projects;");
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
    }
}