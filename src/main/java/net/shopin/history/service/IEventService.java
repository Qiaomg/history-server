package net.shopin.history.service;

import net.shopin.history.enitty.GrpcMsg;

/**
 * @title: IEventService
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/12 10:07
 * @version: V1.0
 */
public interface IEventService {

    void queueEventListener(GrpcMsg msg);
    void refreshTable(GrpcMsg msg);
}
