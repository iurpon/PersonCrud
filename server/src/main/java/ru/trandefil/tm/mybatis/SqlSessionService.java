package ru.trandefil.tm.mybatis;

import org.apache.ibatis.session.SqlSession;

public interface SqlSessionService {

    SqlSession getSqlSession();

    void closeSqlSession(SqlSession sqlSession);

}
