package com.hwq.test;

import com.hwq.binding.MapperProxyFactory;
import com.hwq.dao.IUserDao;

import java.util.HashMap;

/**
 * @author HWQ
 * @date 2024/5/4 22:38
 * @description
 */
public class ApiTest {

//    private static Logger logger = LoggerFactory.getLogger(ApiTest.class);
    public static void main(String[] args) {
        test_MapperProxyFactory();
    }

    public static void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        HashMap<String, String> sqlSession = new HashMap<>();

        sqlSession.put("com.hwq.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中的SQL语句，操作：查询用户名");

        IUserDao userDao = factory.newInstance(sqlSession);
        String result = userDao.queryUserName("1");
        System.out.printf("测试结果{%s}", result);
    }
}
