package com.hwq.mapper;

import com.hwq.entity.User;

/**
 * @author HWQ
 * @date 2024/5/9 09:56
 * @description
 */
public interface UserMapper {
    User queryUserByName(String name);
}
