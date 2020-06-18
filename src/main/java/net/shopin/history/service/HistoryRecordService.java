package net.shopin.history.service;

import java.util.List;
import java.util.Map;

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
     * @param tableName
     * @return
     */
    List<Map<Object,Object>> generalSelect(String tableName);

    /**
     * showTables
     * @return
     */
    List<String> showTables();

}
