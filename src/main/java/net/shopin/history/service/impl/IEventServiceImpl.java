package net.shopin.history.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.shopin.history.enitty.GrpcMsg;
import net.shopin.history.enitty.RequestRecord;
import net.shopin.history.mapper.HistoryRecordMapper;
import net.shopin.history.mapper.RequestMapper;
import net.shopin.history.service.IEventService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

import static net.shopin.history.common.HistoryServerContext.tableMap;

/**
 * @title: EventEventListener
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/12 10:08
 * @version: V1.0
 */
@Slf4j
@Service
public class IEventServiceImpl implements IEventService {
    @Resource
    HistoryRecordMapper historyMapper;
    @Resource
    RequestMapper recordMapper;

    @Async
    @Override
    public void queueEventListener(@NonNull GrpcMsg msg) {
        try {
            //解析消息 获取操作表名
            historyMapper.insertOptSql(msg.getOptSql());
            log.info("执行: --> {}",msg.getOptSql());
        } catch (Exception e) {
            //当前表结构出现变化
            tableMap.put(msg.getTableName(),false);
            saveRequestRecord(msg);
            e.printStackTrace();
        }
    }


    @Async
    public void saveRequestRecord(GrpcMsg msg) {
        RequestRecord rr = new RequestRecord();
        rr.setCreateTime(new Date());
        rr.setType(msg.getType().toString());
        rr.setTableName(msg.getTableName());
        rr.setServerName(msg.getServerName());
        rr.setOptSql(msg.getOptSql());
        log.info("save request record : " + rr);
        recordMapper.insert(rr);
    }

    @Async
    @Override
    public void refreshTable(GrpcMsg msg){
        System.out.printf("msg:"+msg.toJsonString());
    }
}
