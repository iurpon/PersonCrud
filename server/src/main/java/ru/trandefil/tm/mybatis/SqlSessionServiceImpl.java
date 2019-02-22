package ru.trandefil.tm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.trandefil.tm.api.SqlSessionService;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionServiceImpl implements SqlSessionService {

    private SqlSessionFactory sqlSessionFactory;

    {
        init();
    }

    public void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    @Override
    public void closeSqlSession(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }

}
