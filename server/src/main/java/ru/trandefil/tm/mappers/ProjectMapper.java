package ru.trandefil.tm.mappers;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.trandefil.tm.entity.Project;

import java.util.List;

public interface ProjectMapper {

 /*   final String getAll = "SELECT * FROM STUDENT";
    final String getById = "SELECT * FROM STUDENT WHERE ID = #{id}";
    final String deleteById = "DELETE from STUDENT WHERE ID = #{id}";
    final String insert = "INSERT INTO STUDENT (NAME, BRANCH, PERCENTAGE, PHONE, EMAIL ) VALUES (#{name}, #{branch}, #{percentage}, #{phone}, #{email})";
    final String update = "UPDATE STUDENT SET EMAIL = #{email}, NAME = #{name}, BRANCH = #{branch}, PERCENTAGE = #{percentage}, PHONE = #{phone} WHERE ID = #{id}";*/


    final String getAll = "select * from projects";

    @Select(getAll)
    @Results(value = {
            @Result(property = "id", column = "proj_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "userId", column = "user_id")
    })

    List<Project> getAll();

}
