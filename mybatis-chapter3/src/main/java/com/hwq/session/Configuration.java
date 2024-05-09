package com.hwq.session;

import com.hwq.mapping.MappedStatement;
import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author HWQ
 * @date 2024/5/9 23:07
 * @description 核心配置类：数据库配置信息以及映射类的map集合
 */
@Data
public class Configuration {
    // 数据源对象
    private DataSource dataSource;
    // map.xml对象集合 key
    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();
}
