package ru.trandefil.tm.service;

import lombok.NonNull;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.util.EMFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll(@NonNull final String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        final List<Task> tasks = taskRepository.getAll(userId, em);
        em.close();
        return tasks;
    }

    @Override
    public List<Task> getAll() {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        final List<Task> tasks = taskRepository.getAll(em);
        em.close();
        return tasks;
    }

    @Override
    public Task save(@NonNull final String userId, @NonNull final Task task) {
        if (!userId.equals(task.getAssignee().getId())) {
            throw new SecurityAuthorizationException("wrong assigner id.");
        }
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final Task saved = taskRepository.save(task, em);
            em.getTransaction().commit();
            em.close();
            return saved;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
        return null;
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Task task) {
        if (!userId.equals(task.getAssignee())) {
            throw new SecurityAuthorizationException("wrong assigner id.");
        }
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            taskRepository.delete(task, em);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String name) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            boolean result = taskRepository.deleteByName(userId, name, em);
            em.getTransaction().commit();
            em.close();
            return result;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
        return false;
    }

    @Override
    public Task getByName(@NonNull final String userId, @NonNull final String name) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Task task = taskRepository.getByName(userId, name, em);
        em.close();
        return task;
    }

    @Override
    public Task getByid(@NonNull final String userId, @NonNull final String id) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Task task = taskRepository.getByName(userId, id, em);
        em.close();
        return task;
    }

}
