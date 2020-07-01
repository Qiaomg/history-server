package net.shopin.history.listener;

import lombok.extern.slf4j.Slf4j;
import net.shopin.history.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

import static net.shopin.history.common.HistoryServerContext.tableMap;

/**
 * @title: StartListener
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/18 11:07
 * @version: V1.0
 */
@Slf4j
@Component
public class StartListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IHistoryService recordService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<String> list = recordService.showTables();
        for (String s : list) {
            tableMap.put(s,true);
        }
        log.info("onApplicationEvent init tableMap!");
    }
}
