package com.hwq.session;

/**
 * @author HWQ
 * @date 2024/5/9 11:58
 * @description SqlSessionFactory工厂类
 */
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
