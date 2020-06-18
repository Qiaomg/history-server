package net.shopin.history.mapper;

import net.shopin.history.enitty.RequestRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RequestRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RequestRecord record);

    int insertSelective(RequestRecord record);

    RequestRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RequestRecord record);

    int updateByPrimaryKey(RequestRecord record);
}
