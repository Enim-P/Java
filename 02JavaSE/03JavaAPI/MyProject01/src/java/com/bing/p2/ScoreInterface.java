package com.bing.p2;

/**
 * 成绩接口
 */
public interface ScoreInterface<T> {
    // 获取成绩
    T getScore();
    // 设置成绩
    void setSCore(T t);
}
