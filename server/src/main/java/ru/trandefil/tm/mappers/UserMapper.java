package ru.trandefil.tm.mappers;

public interface UserMapper {

    final String getAll = "select * from users";

    final String getAllFilter = "select * from users where user_id = #{id}";

    final String insert = "INSERT INTO users (user_id, name, password, role)" +
            " VALUES (#{id}, #{name}, #{password}, #{role})";

    final String update = "UPDATE users SET name = #{name}, password = #{password}, role = #{role} where user_id = #{id}";

    final String deleteById = "DELETE from users WHERE user_id = #{userId}";

    final String deleteByName = "DELETE from users WHERE user_id = #{userId}";

    final String getById = "select * from users where user_id = #{id}";

    final String getByName = "select * from users where name = #{name}";

}
