package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ConnectionService;
import ru.trandefil.tm.api.ProjectRepository;
import ru.trandefil.tm.entity.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProjectDBRepositoryImpl implements ProjectRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private ConnectionService connectionService;

    public ProjectDBRepositoryImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public Project save(Project project) {
        String insertProject = "INSERT INTO projects"
                + "(proj_id, name, description, user_id) VALUES"
                + "(?,?,?,?)";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(insertProject);
            preparedStatement.setString(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setString(4, project.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. save failed");
        }
        return project;
    }

    @Override
    public List<Project> getAll(String usrId) {
        try {
            String selectAll = "SELECT * FROM projects where userId = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectAll);
            preparedStatement.setString(1,usrId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Project> projectList = new ArrayList<>();
            while (resultSet.next()) {
                String projectId = resultSet.getString("proj_id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String userId = resultSet.getString("user_id");
                Project newProject = new Project(projectId, name, desc, userId);
                projectList.add(newProject);
            }
            return projectList;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. failed getAll");
        }
        return null;
    }

    @Override
    public Project getById(String usrId,String id) {
        try {
            String selectById = "SELECT * FROM projects WHERE proj_id = ? and user_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectById);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, usrId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String projectId = resultSet.getString("proj_id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String userId = resultSet.getString("user_id");
                Project newProject = new Project(projectId, name, desc, userId);
                return newProject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . getById fail");
        }
        return null;
    }

    @Override
    public Project getByName(String usrId,String name) {
        try {
            String selectById = "SELECT * FROM projects WHERE name = ? and user_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectById);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, usrId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String projectId = resultSet.getString("proj_id");
                String incomName = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String userId = resultSet.getString("user_id");
                Project newProject = new Project(projectId, incomName, desc, userId);
                return newProject;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . getById fail");
        }
        return null;
    }

    @Override
    public void delete(String userId,Project project) {
        try {
            String deleteSQL = "DELETE projects WHERE proj_id = ? and user_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(deleteSQL);
            preparedStatement.setString(1, project.getId());
            preparedStatement.setString(2, userId);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. delete failed");
        }
    }

    @Override
    public void deleteByName(String userId,String projectName) {
        try {
            String deleteSQL = "DELETE projects WHERE name = ? and user_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(deleteSQL);
            preparedStatement.setString(1, projectName);
            preparedStatement.setString(2, userId);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. deleteByName failed");
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public Project update(String userId,Project project) {
        String insertProject = "Update projects Set name = ?,description = ? where proj_id = ? and user_id = ?";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(insertProject);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setString(3, project.getId());
            preparedStatement.setString(4, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. save failed");
        }
        return project;
    }

}
