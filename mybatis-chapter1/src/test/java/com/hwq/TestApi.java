package com.hwq;

import com.hwq.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author HWQ
 * @date 2024/5/7 17:11
 * @description
 */
public class TestApi {


    @Test
    public void test() {
        System.out.println("hello");
    }

    @Test
    public void testMybatis() throws IOException {
        InputStream conf = Resources.getResourceAsStream("mybatis-conf.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(conf);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // sqlSession中提供了对数据库的直接增删改查方法，但是推荐使用Mapper的方式
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.queryUserByName("hwq");

    }
}
