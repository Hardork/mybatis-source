package com.hwq.dao;

/**
 * @author HWQ
 * @date 2024/5/4 20:23
 * @description
 */
public interface IUserDao {
    String queryUserName(String uid);

    Integer queryUserAge(String uid);
}
