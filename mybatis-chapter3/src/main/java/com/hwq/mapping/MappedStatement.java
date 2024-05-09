package com.hwq.mapping;

import lombok.Data;

/**
 * @author HWQ
 * @date 2024/5/9 20:57
 * @description
 * 1. 存储mapper.xml解析出来的内容
 * 2. 每一个实体都会对应一个mapper.xml文件即一个MapperStatement对象
 */
@Data
public class MappedStatement {
    // 唯一标识 statementId：namespace.id
    private String statementId;

    // 返回值类型
    private String resultType;

    // 参数类型
    private String parameterType;

    // sql语句
    private String sql;

    // 判断当前是什么操作的一个属性-增删改查
    private String sqlCommandType;
}
