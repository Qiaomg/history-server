package net.shopin.history.mapper;

import net.shopin.history.enitty.RequestRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qiaofan
 */
@Mapper
public interface RequestMapper {
    int deleteByPrimaryKey(Long id);

    @Insert("insert into request_record (`type`, `table_name`, `server_name`, opt_sql, create_time) values (#{type,jdbcType=VARCHAR},#{tableName,jdbcType=VARCHAR},#{serverName,jdbcType=VARCHAR},#{optSql,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
    int insert(RequestRecord record);

    int insertSelective(RequestRecord record);

    RequestRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RequestRecord record);

    int updateByPrimaryKey(RequestRecord record);
}
