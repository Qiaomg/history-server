package net.shopin.history.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.shopin.history.mapper.HistoryRecordMapper;
import net.shopin.history.service.HistoryRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: HistoryRecordServiceImpl
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/11 16:26
 * @version: V1.0
 */
@Slf4j
@Service
public class HistoryRecordServiceImpl implements HistoryRecordService {
    @Resource
    HistoryRecordMapper historyMapper;

    @Override
    public void optSql(String str) {
        historyMapper.insertOptSql(str);
    }

    @Override
    public Object select(Long id, Class clazz) {
        return historyMapper.select(id,clazz);
    }
}
