package ru.trandefil.tm.service;


import lombok.NonNull;
import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.ProjectService;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.mappers.ProjectMapper;
import ru.trandefil.tm.util.UUIDUtil;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ProjectServiceImpl implements ProjectService {

    private SqlSessionService sqlSessionService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public ProjectServiceImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public Project save(@NonNull String userId, @NonNull Project project) {
        if (!project.getUserId().equals(userId)) {
            throw new SecurityAuthorizationException(" modifying project denied.");
        }
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        if (project.isNew()) {
            project.setId(UUIDUtil.getUniqueString());
            System.out.format("saving new project : %s", project.getName());
            projectMapper.insert(project);
            sqlSessionService.closeSqlSession(sqlSession);
            return project;
        }
        projectMapper.update(project);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

    @Override
    public List<Project> getAll(@NonNull String userId) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        List<Project> projectList = projectMapper.getAllFilter(userId);
        sqlSessionService.closeSqlSession(sqlSession);
        return projectList;
    }

    @Override
    public Project getById(String userId, String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        Project byId = projectMapper.getById(userId,name);
        sqlSessionService.closeSqlSession(sqlSession);
        if (byId == null) {
            System.out.println("Wrong project name.");
            return null;
        }
        if (!byId.getUserId().equals(userId)) {
            System.out.println("don't have permission to update this project.");
            throw new SecurityAuthorizationException("delete project denied.");
        }
        return byId;
    }

    @Override
    public void delete(String userId, Project project) {
        if (!project.getUserId().equals(userId)) {
            throw new SecurityAuthorizationException("delete project denied.");
        }
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        projectMapper.deleteById(project);
        sqlSessionService.closeSqlSession(sqlSession);
    }

    @Override
    public void deleteByName(String userId, String projectName) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        projectMapper.deleteByName(userId,projectName);
        sqlSessionService.closeSqlSession(sqlSession);
    }

    @Override
    public Project getByName(String projectName, String userId) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = projectMapper.getByName(userId,projectName);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

}
