package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectMapper {

    final String getAll = "select * from projects";

    final String getAllFilter = "select * from projects where user_id = #{userId}";

    final String insert = "INSERT INTO projects (proj_id, name, description, user_id)" +
            " VALUES (#{id}, #{name}, #{description}, #{userId})";

    final String update = "UPDATE projects SET name = #{name}, description = #{description} where proj_id = #{id}";

    final String deleteById = "DELETE from projects WHERE proj_id = #{id} and user_id = #{userId}";

    final String deleteByName = "DELETE from projects WHERE user_id = #{userId} and name = #{name}";

    final String getById = "select * from projects where proj_id = #{id}";

    final String getByName = "select * from projects where user_id = #{userId} and name = #{name}";

    @Select(getAll)
    @Results(value = {
            @Result(property = "id", column = "proj_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId", column = "user_id")
    })
    List<Project> getAll();

    @Select(getAllFilter)
    @Results(value = {
            @Result(property = "id", column = "proj_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId", column = "user_id")
    })
    List<Project> getAllFilter(@Param("userId") String userId);

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "proj_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId", column = "user_id")
    })
    Project getById(@Param("id")String id, @Param("userId")String userId);

    @Select(getByName)
    @Results(value = {
            @Result(property = "id", column = "proj_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId", column = "user_id")
    })
    Project getByName(@Param("userId")String userId, @Param("name") String name);

    @Insert(insert)
    void insert(Project project);

    @Update(update)
    void update(Project project);

    @Delete(deleteById)
    void deleteById(Project project);

    @Delete(deleteByName)
    void deleteByName(@Param("userId")String userId, @Param("name")String name);

}
