package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskMapper {

    @Select("select * from tasks")
    @Results(value = {
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    List<Task> getAll();

    @Select("select * from tasks where assigner_id = #{userId} or executor_id = #{userId}")
    @Results(value = {
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    List<Task> getAllFiltered(String userId);

    @Select("select * from tasks where id = #{id}")
    @Results(value = {
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    Task getById(Task task);

    @Select("select * from tasks where name = #{name} and assigner_id = #{assigneeId}")
    @Results(value = {
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    Task getByName(@Param("assigneeId") String assigneeId, @Param("name") String name);

    @Insert("INSERT INTO tasks " +
            "(id, name, description, begin, end, proj_id, assigner_id, executor_id)" +
            " VALUES " +
            "(#{id}, #{name}, #{description}, #{begin}, #{end}, #{projectId}, #{assigneeId}, #{executorId})")
    void insert(Task user);

    @Update("UPDATE tasks SET " +
            " name = #{name}," +
            " description = #{description}," +
            " begin = #{begin}, " +
            " end = #{end} ," +
            " executor_id = #{executorId} " +
            " where id = #{id}")
    void update(Task user);

    @Delete("DELETE from tasks WHERE id = #{id}")
    void deleteById(Task user);

    @Delete("DELETE from tasks WHERE name = #{name}")
    void deleteByName(@Param("name") String name);

}
