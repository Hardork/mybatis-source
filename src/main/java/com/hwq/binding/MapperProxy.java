package com.hwq.binding;


import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author HWQ
 * @date 2024/5/4 20:39
 * @description
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Class<T> mapperInterface, Map<String, String> sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) { // Object本身的函数
            return method.invoke(this, args);
        } else {
            return sqlSession.get(mapperInterface.getName() + "." + method.getName()) + "被调用";
        }
    }
}
