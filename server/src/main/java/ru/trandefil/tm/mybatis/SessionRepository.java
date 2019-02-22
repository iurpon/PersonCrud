package ru.trandefil.tm.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import ru.trandefil.tm.entity.Session;

public interface SessionRepository {

    @Delete("DELETE from sessions WHERE id = #{id}")
    void deleteById(String id);

    @Insert("INSERT INTO sessions (id, timestamp, user_id, role, signature)" +
            " VALUES (#{id}, #{timestamp}, #{userId}, #{role}, #{signature})")
    void insert(Session session);

}
