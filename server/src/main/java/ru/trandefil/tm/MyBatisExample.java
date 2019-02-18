package ru.trandefil.tm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import ru.trandefil.tm.entity.Project;
import ru.trandefil.tm.mappers.ProjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyBatisExample {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        ProjectMapper mapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml"); //Читаем файл с настройками подключения и настройками MyBatis
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
//            session.getConfiguration().addMapper(ProjectMapper.class);
            mapper = session.getMapper(ProjectMapper.class);

            List<Project> subscribers = mapper.getAll();
            subscribers.forEach(System.out::println);

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
