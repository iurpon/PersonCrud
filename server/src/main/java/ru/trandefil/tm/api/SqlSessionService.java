package ru.trandefil.tm.api;

import org.apache.ibatis.session.SqlSession;

public interface SqlSessionService {

    SqlSession getSqlSession();

    void closeSqlSession(SqlSession sqlSession);

}
