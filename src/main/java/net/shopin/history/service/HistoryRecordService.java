package net.shopin.history.service;

/**
 * @title: HistoryRecordService
 * @description: 定义操作接口
 * @author: qmg
 * @date: 2020/6/11 16:25
 * @version: V1.0
 */
public interface HistoryRecordService {

    /**
     * 执行sql
     * @param str
     */
    void optSql(String str);

    /**
     * 查询demo
     * @param id
     * @param clazz
     * @return
     */
    Object select(Long id,Class clazz);

}
