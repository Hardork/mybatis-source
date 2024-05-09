package com.hwq.session.defaults;

import com.hwq.binding.MapperRegister;
import com.hwq.session.SqlSession;
import com.hwq.session.SqlSessionFactory;

/**
 * @author HWQ
 * @date 2024/5/8 17:37
 * @description
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegister mapperRegister;

    public DefaultSqlSessionFactory(MapperRegister mapperRegister) {
        this.mapperRegister = mapperRegister;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegister);
    }
}
