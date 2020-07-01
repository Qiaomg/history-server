package net.shopin.history.api;

import lombok.extern.slf4j.Slf4j;
import net.shopin.history.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import static net.shopin.history.common.HistoryServerContext.tableMap;

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
    private IHistoryService historyService;

    @GetMapping("/tables")
    public Object tables() {
        return tableMap;
    }

    @GetMapping("/table/{tableName}")
    public Object loadTableByName(@PathVariable String tableName) {
        if(StringUtils.isEmpty(tableName)){
            return "参数空";
        }
        return historyService.generalSelect(tableName);
    }
}
