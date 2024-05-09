package com.hwq.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author HWQ
 * @date 2024/5/4 21:20
 * @description：映射代理工厂 JDK动态代理，基于接口
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
    public T newInstance(Map<String, String> sqlSession) {
        MapperProxy<T> mapperProxy = (MapperProxy<T>) new MapperProxy<>(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
