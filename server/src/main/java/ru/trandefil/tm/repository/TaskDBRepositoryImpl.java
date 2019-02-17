package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ConnectionService;
import ru.trandefil.tm.api.TaskRepository;
import ru.trandefil.tm.entity.Task;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class TaskDBRepositoryImpl implements TaskRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private ConnectionService connectionService;

    public TaskDBRepositoryImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @Override
    public List<Task> getAll(String usId) {
        try {
            final String selectAll = "SELECT * FROM tasks WHERE assigner_id = ? OR executor_id = ?";
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectAll);
            preparedStatement.setString(1, usId);
            preparedStatement.setString(2, usId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            final List<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                final String userId = resultSet.getString("task_id");
                final String name = resultSet.getString("name");
                final String desc = resultSet.getString("description");
                final Date startDate = resultSet.getDate("startDate");
                final Date endDate = resultSet.getDate("endDate");
                final String projId = resultSet.getString("proj_id");
                final String assigner = resultSet.getString("assigner_id");
                final String executor = resultSet.getString("executor_id");
                final Task task = new Task(userId, name, desc, startDate, endDate, projId, assigner, executor);
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. failed getAll task");
        }
        return null;
    }

    @Override
    public Task save(Task task) {
        final String insertTask = "INSERT INTO tasks"
                + "(task_id, name, description, startDate,endDate,proj_id,assigner_id,executor_id) VALUES"
                + "(?,?,?,?,?,?,?,?)";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(insertTask);
            preparedStatement.setString(1, task.getId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setDate(4,
                    new java.sql.Date(task.getBegin() == null ? null : task.getBegin().getTime()));
            preparedStatement.setDate(5,
                    new java.sql.Date(task.getEnd() == null ? null : task.getEnd().getTime()));
            preparedStatement.setString(6, task.getProjectId());
            preparedStatement.setString(7, task.getAssigneeId());
            preparedStatement.setString(8, task.getExecuterId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. save task failed");
        }
        return task;
    }

    @Override
    public Task update(Task task) {
        String updateTask = "Update tasks Set " +
                "name = ?," +
                "description = ?," +
                "startDate = ?," +
                "endDate = ?," +
                "executor_id = ?" +
                "where task_id = ?";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(updateTask);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3,
                    new java.sql.Date(task.getBegin() == null ? null : task.getBegin().getTime()));
            preparedStatement.setDate(4,
                    new java.sql.Date(task.getEnd() == null ? null : task.getEnd().getTime()));
            preparedStatement.setString(5, task.getExecuterId());
            preparedStatement.setString(6, task.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. update task failed");
        }
        return task;
    }

    @Override
    public Task delete(String userId, Task task) {
        return deleteByName(userId, task.getName());
    }

    @Override
    public Task deleteByName(String userId, String name) {
        try {
            Task task = getByName(userId, name);
            if (task == null) {
                return null;
            }
            String deleteByName = "DELETE from tasks WHERE name = ? AND aasigner_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(deleteByName);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, userId);
            preparedStatement.executeUpdate();
            return task;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . deleteByName task  fail");
        }
        return null;
    }

    @Override
    public Task getByName(String userId, String name) {
        String selectTask = "SELECT * FROM tasks WHERE name = ? AND assigner_id = ? OR executor_id = ?";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectTask);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, userId);
            preparedStatement.setString(3, userId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final String taskId = resultSet.getString("task_id");
                final String incomeName = resultSet.getString("name");
                final String desc = resultSet.getString("description");
                final Date startDate = resultSet.getDate("startDate");
                final Date endDate = resultSet.getDate("endDate");
                final String projId = resultSet.getString("proj_id");
                final String assigner = resultSet.getString("assigner_id");
                final String executor = resultSet.getString("executor_id");
                final Task task = new Task(taskId, incomeName, desc, startDate, endDate, projId, assigner, executor);
                logger.info("returning task : " + task);
                return task;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. getByName task failed");
        }
        logger.info("no task found by name");
        return null;
    }

    @Override
    public void clear() {
        try {
            String truncate = "TRUNCATE TABLE tasks";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(truncate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.info("truncate table tasks failed.");
            e.printStackTrace();
        }
    }

    @Override
    public Task getByid(String usrId, String id) {
        String selectTask = "SELECT * FROM tasks WHERE task_id = ? AND assigner_id = ? OR executor_id = ?";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectTask);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, usrId);
            preparedStatement.setString(3, usrId);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final String userId = resultSet.getString("task_id");
                final String incomeName = resultSet.getString("name");
                final String desc = resultSet.getString("description");
                final Date startDate = resultSet.getDate("startDate");
                final Date endDate = resultSet.getDate("endDate");
                final String projId = resultSet.getString("proj_id");
                final String assigner = resultSet.getString("assigner_id");
                final String executor = resultSet.getString("executor_id");
                final Task task = new Task(userId, incomeName, desc, startDate, endDate, projId, assigner, executor);
                return task;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. getById task failed");
        }
        return null;
    }
}
