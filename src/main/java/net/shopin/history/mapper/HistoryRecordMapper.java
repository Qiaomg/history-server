package net.shopin.history.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select({"select * from market_activity_history where id = #{id}"})
    Object select(@Param("id")Long id, @Param("resultType") Class clazz);
}
