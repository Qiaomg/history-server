package net.shopin.history.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @title: HistoryRecordMapper
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/11 16:17
 * @version: V1.0
 */
@Mapper
public interface HistoryRecordMapper {

    @Insert({"${sql}"})
    int insertOptSql(String sql);

    @Select({"select * from ${tableName}"})
    List<Map<Object,Object>> generalSelect(String tableName);

    @Select({"show tables from shopin_history"})
    List<String> showTables();
}
