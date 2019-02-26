package ru.trandefil.tm.repository;

import lombok.NonNull;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.util.UUIDUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public List<Task> getAll(@NonNull String userId, @NonNull EntityManager em) {
        final Query query = em.createQuery("select t from Task t where t.assignee = :userId or t.executor = :userId");
        query.setParameter("userId", userId);
        final List<Task> tasks = query.getResultList();
        return tasks;
    }

    @Override
    public List<Task> getAll(@NonNull EntityManager em) {
        final Query query = em.createQuery("select t from Task t ");
        final List<Task> tasks = query.getResultList();
        return tasks;
    }

    @Override
    public Task save(@NonNull String userId, @NonNull Task task, @NonNull EntityManager em) {
        if (task.isNew()) {
            task.setId(UUIDUtil.getUniqueString());
            em.persist(task);
            return task;
        }
        return em.merge(task);
    }

    @Override
    public void delete(@NonNull Task task, @NonNull EntityManager em) {
        em.remove(task);
    }

    @Override
    public boolean deleteByName(@NonNull String userId, @NonNull String name, @NonNull EntityManager em) {
        Query query = em.createQuery("delete from Task t where t.assignee =:userId and t.name = :name");
        query.setParameter("userId",userId);
        query.setParameter("name",name);
        int result = query.executeUpdate();
        return result != 0;
    }

    @Override
    public Task getByName(@NonNull String userId, @NonNull String name, @NonNull EntityManager em) {
        Query query = em.createQuery("select t from Task t where t.name = :name and (t.assignee = :userId or t.executor = :userId");
        query.setParameter("name",name);
        query.setParameter("userId",userId);
        Task task = (Task) query.getSingleResult();
        return task;
    }

    @Override
    public Task getByid(@NonNull String userId, @NonNull String id, @NonNull EntityManager em) {
        Query query = em.createQuery("select t from Task t where t.id = :id and (t.assignee = :userId or t.executor = :userId");
        query.setParameter("userId",userId);
        query.setParameter("id",id);
        Task task = (Task) query.getSingleResult();
        return task;
    }

}
