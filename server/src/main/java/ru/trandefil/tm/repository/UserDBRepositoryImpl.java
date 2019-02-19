package ru.trandefil.tm.repository;

import ru.trandefil.tm.api.ConnectionService;
import ru.trandefil.tm.api.UserRepository;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDBRepositoryImpl implements UserRepository {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private ConnectionService connectionService;

    public UserDBRepositoryImpl(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }


    @Override
    public User delete(User user) {
        return deleteByName(user.getName());
    }

    @Override
    public User deleteByName(String name) {
        try {
            User user = getByName(name);
            if (user == null) {
                return null;
            }
            String deleteByName = "DELETE users WHERE name = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(deleteByName);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . deleteByName user  fail");
        }
        return null;
    }

    @Override
    public User save(User user) {
        String insertUser = "INSERT INTO users"
                + "(user_id, name, password, role) VALUES"
                + "(?,?,?,?)";
        try {
            final PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(insertUser);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRole().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. save user failed");
        }
        return user;

    }

    @Override
    public User getByName(String userName) {
        try {
            String selectByName = "SELECT * FROM users WHERE name = ? ";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectByName);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user_id = resultSet.getString("user_id");
                String incomName = resultSet.getString("name");
                String password = resultSet.getString("password");
                Role role = Enum.valueOf(Role.class, resultSet.getString("role"));
                User user = new User(user_id, incomName, password, role);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . getLoginUser  fail");
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            String selectAll = "SELECT * FROM users";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectAll);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String name = resultSet.getString("name");
                String pass = resultSet.getString("password");
                Role role = Enum.valueOf(Role.class, resultSet.getString("role"));
                User user = new User(userId, name, pass, role);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception. failed getAll users");
        }
        return null;
    }

    @Override
    public User getLoginUser(String userName, String userPassword) {
        try {
            String selectByNameAndPass = "SELECT * FROM users WHERE name = ? AND password = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectByNameAndPass);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user_id = resultSet.getString("user_id");
                String incomName = resultSet.getString("name");
                String password = resultSet.getString("password");
                Role role = Enum.valueOf(Role.class, resultSet.getString("role"));
                User user = new User(user_id, incomName, password, role);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . getLoginUser  fail");
        }
        return null;
    }

    @Override
    public void clear() {
        try {
            String truncate = "TRUNCATE TABLE users";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(truncate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.info("truncate table users failed.");
            e.printStackTrace();
        }

    }

    @Override
    public User getById(String id) {
        try {
            String selectById = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement preparedStatement = connectionService.getDbConnect().prepareStatement(selectById);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String user_id = resultSet.getString("user_id");
                String incomName = resultSet.getString("name");
                String password = resultSet.getString("password");
                Role role = Enum.valueOf(Role.class, resultSet.getString("role"));
                User user = new User(user_id, incomName, password, role);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("exception . getById user  fail");
        }
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
