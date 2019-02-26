package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class TaskRepositoryImpl implements TaskRepository {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Task> getAll(@NonNull String userId, @NonNull EntityManager em) {
        logger.info(" repo getAll();");
        final Query query = em.createQuery("select t from Task t where t.assignee.id = :userId or t.executor = :userId");
        query.setParameter("userId", userId);
        final List<Task> tasks = query.getResultList();
        logger.info("returning : " + tasks);
        return tasks;
    }

    @Override
    public List<Task> getAll(@NonNull EntityManager em) {
        logger.info("repo getAll()");
        final Query query = em.createQuery("select t from Task t ");
        final List<Task> tasks = query.getResultList();
        logger.info("returning " + tasks);
        return tasks;
    }

    @Override
    public Task save(@NonNull Task task, @NonNull EntityManager em) {
        logger.info("repo save");
        if (task.isNew()) {
            task.setId(UUIDUtil.getUniqueString());
            em.persist(task);
            logger.info("returning " + task);
            return task;
        }
        logger.info("returning " + task);
        return em.merge(task);
    }

    @Override
    public void delete(@NonNull Task task, @NonNull EntityManager em) {
        logger.info("repo delete");
        em.remove(task);
    }

    @Override
    public boolean deleteByName(@NonNull String userId, @NonNull String name, @NonNull EntityManager em) {
        logger.info("repo deleteByName");
        Query query = em.createQuery("delete from Task t where t.assignee.id =:userId and t.name = :name");
        query.setParameter("userId",userId);
        query.setParameter("name",name);
        int result = query.executeUpdate();
        logger.info("deleted by name ? : " + (result!=0));
        return result != 0;
    }

    @Override
    public Task getByName(@NonNull String userId, @NonNull String name, @NonNull EntityManager em) {
        logger.info("getByName repo");
        Query query = em.createQuery("select t from Task t where (t.assignee.id = :userId or t.executor.id = :userId) and t.name = :name");
        query.setParameter("name",name);
        query.setParameter("userId",userId);
        Task task = (Task) query.getSingleResult();
        logger.info("returning " + task);
        return task;
    }

    @Override
    public Task getByid(@NonNull String userId, @NonNull String id, @NonNull EntityManager em) {
        logger.info("repo getById");
        Query query = em.createQuery("select t from Task t where (t.assignee.id = :userId or t.executor.id = :userId) and dt.id = :id");
        query.setParameter("userId",userId);
        query.setParameter("id",id);
        Task task = (Task) query.getSingleResult();
        logger.info("returning " + task);
        return task;
    }

}
