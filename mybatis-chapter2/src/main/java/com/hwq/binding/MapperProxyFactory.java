package com.hwq.binding;

import com.hwq.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author HWQ
 * @date 2024/5/8 17:35
 * @description Mapper的代理工厂
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;


    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 生成代理对象
     * @param sqlSession
     * @return
     */
    public T newInstance(SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = (MapperProxy<T>) new MapperProxy<>(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}