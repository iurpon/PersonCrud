package ru.trandefil.tm.api;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.User;

import java.util.List;

public interface UserRepository {

    @Select("select * from users")
    List<User> getAll();

    @Select("select * from users where name = #{name}")
    User getByName(@Param("name") String name);

    @Select("select * from users where name = #{name} and password = #{password}")
    User getByNameAndPass(@Param("name") String name, @Param("password") String password);

    @Insert("INSERT INTO users (id, name, password, role)" +
            " VALUES (#{id}, #{name}, #{password}, #{role})")
    void insert(User user);

    @Update("UPDATE users SET name = #{name}, password = #{password}, role = #{role} where id = #{id}")
    void update(User user);

    @Delete("DELETE from users WHERE id = #{id}")
    void deleteById(User user);

    @Delete("DELETE from users WHERE name = #{name}")
    void deleteByName(@Param("name") String name);

}
