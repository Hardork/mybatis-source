package com.hwq.binding;

import com.hwq.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author HWQ
 * @date 2024/5/8 17:35
 * @description Mapper代理类
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) { // Object本身的函数
            return method.invoke(this, args);
        } else {
            // 调用mapper对应的方法
            return (mapperInterface.getName() + "." + method.getName()) + "被调用";
        }
    }
}
