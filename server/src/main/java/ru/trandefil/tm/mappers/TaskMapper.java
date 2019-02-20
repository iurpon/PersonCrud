package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.*;
import ru.trandefil.tm.entity.Task;

import java.util.List;

public interface TaskMapper {

    final String getAll = "select * from tasks";

    final String getAllFiltered = "select * from tasks where assigner_id = #{userId} or executor_id = #{userId}";

    final String getById = "select * from tasks where task_id = #{id}";

    final String getByName = "select * from tasks where name = #{name} and assigner_id = #{assigneeId}";

    final String insert =
            "INSERT INTO tasks " +
                    "(task_id, name, description,  startDate, endDate, proj_id, assigner_id, executor_id)" +
                    " VALUES " +
                    "(#{id}, #{name}, #{description}, #{begin}, #{end}, #{projectId}, #{assigneeId}, #{executorId})";

    final String update = "UPDATE tasks SET " +
            " name = #{name}," +
            " description = #{description}," +
            " startDate = #{begin}, " +
            " endDate = #{end} ," +
            " executor_id = #{executorId} " +
            " where task_id = #{id}";

    final String deleteById = "DELETE from tasks WHERE task_id = #{id}";

    final String deleteByName = "DELETE from tasks WHERE name = #{name}";


    @Select(getAll)
    @Results(value = {
            @Result(property = "id", column = "task_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "begin", column = "startDate"),
            @Result(property = "end", column = "endDate"),
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    List<Task> getAll();

    @Select(getAllFiltered)
    @Results(value = {
            @Result(property = "id", column = "task_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "begin", column = "startDate"),
            @Result(property = "end", column = "endDate"),
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    List<Task> getAllFiltered(String userId);

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "task_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "begin", column = "startDate"),
            @Result(property = "end", column = "endDate"),
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    Task getById(Task task);

    @Select(getByName)
    @Results(value = {
            @Result(property = "id", column = "task_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "begin", column = "startDate"),
            @Result(property = "end", column = "endDate"),
            @Result(property = "projectId", column = "proj_id"),
            @Result(property = "assigneeId", column = "assigner_id"),
            @Result(property = "executorId", column = "executor_id")
    })
    Task getByName(@Param("assigneeId") String assigneeId, @Param("name") String name);

    @Insert(insert)
    void insert(Task user);

    @Update(update)
    void update(Task user);

    @Delete(deleteById)
    void deleteById(Task user);

    @Delete(deleteByName)
    void deleteByName(@Param("name") String name);

}
