package ru.trandefil.tm.repository;

import org.apache.ibatis.session.SqlSession;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.api.SqlSessionService;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.mappers.ProjectMapper;

import java.util.List;

public class ProjectMBRepositoryImpl implements ProjectRepository {

    private SqlSessionService sqlSessionService;

    public ProjectMBRepositoryImpl(SqlSessionService sqlSessionService) {
        this.sqlSessionService = sqlSessionService;
    }

    @Override
    public Project save(Project project) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        projectMapper.insert(project);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

    @Override
    public List<Project> getAll(String userId) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        List<Project> projectList = projectMapper.getAllFilter(userId);
        sqlSessionService.closeSqlSession(sqlSession);
        return projectList;
    }

    @Override
    public Project getById(String userId, String id) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = projectMapper.getById(id,userId);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

    @Override
    public Project getByName(String userId, String name) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        Project project = projectMapper.getByName(userId,name);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

    @Override
    public void delete(Project project) {
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
    public void clear() {

    }

    @Override
    public Project update(Project project) {
        SqlSession sqlSession = sqlSessionService.getSqlSession();
        ProjectMapper projectMapper = sqlSession.getMapper(ProjectMapper.class);
        projectMapper.update(project);
        sqlSessionService.closeSqlSession(sqlSession);
        return project;
    }

}
