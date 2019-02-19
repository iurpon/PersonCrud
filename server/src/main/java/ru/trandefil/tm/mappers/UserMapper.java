package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserMapper {

    final String getAll = "select * from users";

    final String insert = "INSERT INTO users (user_id, name, password, role)" +
            " VALUES (#{id}, #{name}, #{password}, #{role})";

    final String update = "UPDATE users SET name = #{name}, password = #{password}, role = #{role} where user_id = #{id}";

    final String deleteById = "DELETE from users WHERE user_id = #{id}";

    final String deleteByName = "DELETE from users WHERE name = #{name}";

    final String getById = "select * from users where user_id = #{id}";

    final String getByName = "select * from users where name = #{name}";

    final String getByNameAndPass = "select * from users where name = #{name} and password = #{password}";

    @Select(getAll)
    @Results(value = {
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    List<User> getAll();

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    User getById(@Param("id")String id);

    @Select(getByName)
    @Results(value = {
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    User getByName(@Param("name") String name);

    @Select(getByNameAndPass)
    @Results(value = {
            @Result(property = "id", column = "user_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "role", column = "role")
    })
    User getByNameAndPass(@Param("name") String name,@Param("password") String password);

    @Insert(insert)
    void insert(User user);

    @Update(update)
    void update(User user);

    @Delete(deleteById)
    void deleteById(User user);

    @Delete(deleteByName)
    void deleteByName(@Param("name")String name);

}
