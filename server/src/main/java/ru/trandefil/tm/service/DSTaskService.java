package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.trandefil.tm.api.TaskService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.Task;
import ru.trandefil.tm.exception.RepositoryLayerException;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.repository.DSTaskRepository;
import ru.trandefil.tm.util.UUIDUtil;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Transactional
public class DSTaskService implements TaskService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private DSTaskRepository taskRepository;

    @Override
    public List<Task> getAll(@NonNull final String userId) {
        try {
            return taskRepository.getAll(userId);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public List<Task> getAll() {
        try {
            return taskRepository.findAll();
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Task save(@NonNull final String userId, @NonNull final Task task) {
        try {
            if (!task.getAssignee().getId().equals(userId)) {
                throw new SecurityAuthorizationException("bad userId");
            }
            if (task.isNew()) {
                task.setId(UUIDUtil.getUniqueString());
                taskRepository.persist(task);
                return task;
            }
            return taskRepository.merge(task);
        } catch (SecurityAuthorizationException e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Task task) {
        if (!task.getAssignee().getId().equals(userId)) {
            throw new SecurityAuthorizationException("bad userId");
        }
        try {
            taskRepository.remove(task);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String name) {
        try {
            int result = taskRepository.deleteByName(userId, name);
            return  result != 0;
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Task getByName(@NonNull final String userId, @NonNull final String name) {
        try {
            return taskRepository.getByName(userId, name);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Task getByid(String userId, String id) {
        try {
            return taskRepository.getByid(userId, id);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

}
