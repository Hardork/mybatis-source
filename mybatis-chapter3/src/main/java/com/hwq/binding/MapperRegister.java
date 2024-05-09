package com.hwq.binding;

import cn.hutool.core.lang.ClassScanner;
import com.hwq.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author HWQ
 * @date 2024/5/8 17:35
 * @description Mapper注册器
 */
public class MapperRegister {



    /**
     * 将已添加的映射器代理加入到HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " +type + " is not known to the MapperRegister");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public void addMapper(Class<?> type) {
        // mapper必须是接口
        if (type.isInterface()) {
            if (hasMapper(type)) { // 已存在这个mapper
                throw new RuntimeException("Type " + type + " is already known to the MapRegister");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public boolean hasMapper(Class<?> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        // 扫描包路径下的所有类文件
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        // 将这些Mapper添加到HashMap中
        mapperSet.forEach(this::addMapper);
    }
}
