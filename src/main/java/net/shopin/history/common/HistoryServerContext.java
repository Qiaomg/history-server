package net.shopin.history.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @title: HistoryServerContext
 * @description: 服务器上下文容器
 * @author: qmg
 * @date: 2020/6/12 10:09
 * @version: V1.0
 */
public class HistoryServerContext {

    /**
     * rpc 消息接收端口号
     */
    public static int PORT = 50051;

    /**
     * 工作线程池
     */
    public static ExecutorService executorService = new ThreadPoolExecutor(2, 10, 5, TimeUnit.MINUTES, new SynchronousQueue<>(),new ThreadFactoryBuilder().setNameFormat("worker-%d").build(),new ThreadPoolExecutor.AbortPolicy());

    /**
     * 记录表上下文, 启动加载
     * 记录格式
     * key : 表名
     * val : 实体类
     */
    public static Map<String,Boolean> tableMap = new HashMap<>();
}
