package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectMapper {

    @Select("select * from projects")
    @Results(value = {
            @Result(property = "userId", column = "user_id")
    })
    List<Project> getAll();

    @Select("select * from projects where user_id = #{userId}")
    @Results(value = {
            @Result(property = "userId", column = "user_id")
    })
    List<Project> getAllFilter(@Param("userId") String userId);

    @Select("select * from projects where id = #{id}")
    @Results(value = {
            @Result(property = "userId", column = "user_id")
    })
    Project getById(@Param("id") String id, @Param("userId") String userId);

    @Select("select * from projects where user_id = #{userId} and name = #{name}")
    @Results(value = {
            @Result(property = "userId", column = "user_id")
    })
    Project getByName(@Param("userId") String userId, @Param("name") String name);

    @Insert("INSERT INTO projects (proj_id, name, description, user_id)" +
            " VALUES (#{id}, #{name}, #{description}, #{userId})")
    void insert(Project project);

    @Update("UPDATE projects SET name = #{name}, description = #{description} where id = #{id}")
    void update(Project project);

    @Delete("DELETE from projects WHERE id = #{id} and user_id = #{userId}")
    void deleteById(Project project);

    @Delete("DELETE from projects WHERE user_id = #{userId} and name = #{name}")
    void deleteByName(@Param("userId") String userId, @Param("name") String name);

}
