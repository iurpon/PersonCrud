package ru.trandefil.tm.service;

import lombok.NonNull;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.RepositoryLayerException;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.repository.DSProjectRepository;
import ru.trandefil.tm.repository.DSUserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Transactional
public class DSProjectService implements ProjectService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private DSProjectRepository projectRepository;

    @Inject
    private DSUserRepository userRepository;

    @Override
    public Project save(@NonNull final String userId, @NonNull final String name, @NonNull final String description) {
        try {
            logger.info("dsProjectService save");
            final User user = userRepository.findBy(userId);
            if (user == null) {
                logger.info("save project failed.user is null.");
                throw new SecurityAuthorizationException("bad userId");
            }
            final Project project = new Project(null, name, description, user);
            return projectRepository.save(project);
        } catch (SecurityAuthorizationException e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public List<Project> getAll(@NonNull final String userId) {
        try {
            return projectRepository.getAllFiltered(userId);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public List<Project> getAll() {
        try {
            return projectRepository.findAll();
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Project getById(@NonNull final String id, @NonNull final String userId) {
        try {
            return projectRepository.getByUserId(id, userId);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Project project) {
        if (!project.getUser().getId().equals(userId)) {
            throw new SecurityAuthorizationException("bad userId");
        }
        try {
            projectRepository.remove(project);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String projectName) {
        try {
            int result = projectRepository.removeByName(projectName, userId);
            return result != 0;
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Project getByName(@NonNull final String userId, @NonNull final String projectName) {
        try {
            return projectRepository.getByName(userId, projectName);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public Project update(@NonNull final Project project) {
        try {
            return projectRepository.merge(project);
        } catch (Exception e) {
            throw new RepositoryLayerException(e.getMessage());
        }
    }

}
