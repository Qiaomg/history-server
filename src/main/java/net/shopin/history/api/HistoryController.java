package net.shopin.history.api;

import lombok.extern.slf4j.Slf4j;
import net.shopin.history.enitty.ActivityHistory;
import net.shopin.history.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title: HistoryController
 * @description: TODO(用一句话描述该文件做什么)
 * @author: qmg
 * @date: 2020/6/11 17:51
 * @version: V1.0
 */
@Slf4j
@RestController
public class HistoryController {

    @Autowired
    private HistoryRecordService historyService;

    @GetMapping("/test")
    public Object edit() {
        log.info("test");
        return historyService.select(469L, ActivityHistory.class);
    }
}
