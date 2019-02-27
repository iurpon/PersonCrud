package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class ProjectRepositoryImpl implements ProjectRepository {

    private Logger logger = Logger.getLogger(this.getClass().getName());
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
    public Project getByName(String userId, String name, EntityManager em) {
        logger.info("task repo getByName");
        Query query = em.createQuery("select p from Project p where p.user.id = :userId and p.name = :name");
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project getById(String userId, String projectId, EntityManager em) {
        logger.info("task repo getById");
        Query query = em.createQuery("select p from Project p where p.user.id = :userId and p.id = :projectId");
        query.setParameter("userId", userId);
        query.setParameter("projectId", projectId);
        Project project = (Project) query.getSingleResult();
        return project;
    }

    @Override
    public Project save(Project project, EntityManager em) {
        logger.info("task repo save");
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            em.persist(project);
            return project;
        }
        return em.merge(project);
    }

    @Override
    public void delete(Project project, EntityManager em) {
        logger.info("task repo delete");
        em.remove(project);
    }

    @Override
    public boolean deleteByName(String userId, String projectName, EntityManager em) {
/*        Query query = em.createQuery("delete from Project p where p.user.id = :userId and p.name = :projectName");
        query.setParameter("projectName",projectName);
        query.setParameter("userId",userId);
        int result = query.executeUpdate();*/
        logger.info("task repo deleteByName");
        Project project = getByName(userId,projectName,em);
        if(project == null){
            logger.info("wrong project name.");
            return false;
        }
        delete(project,em);
        return true;
    }

}
