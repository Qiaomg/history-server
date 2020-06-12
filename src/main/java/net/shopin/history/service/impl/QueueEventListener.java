package net.shopin.history.service.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.shopin.history.enitty.GrpcMsg;
import net.shopin.history.service.HistoryRecordService;
import net.shopin.history.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @title: QueueEventListener
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/12 10:08
 * @version: V1.0
 */
@Slf4j
@Service
public class QueueEventListener implements QueueService {
    @Autowired
    private HistoryRecordService historyService;

    @Async
    @Override
    public void queueEventListener(@NonNull GrpcMsg msg) {
        //解析消息 获取操作表名
        historyService.optSql(msg.getOptSql());
        log.info("执行: --> {}",msg.getOptSql());
    }
}
