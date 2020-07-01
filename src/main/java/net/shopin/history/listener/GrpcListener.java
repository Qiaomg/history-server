package net.shopin.history.listener;

import io.grpc.history.GreeterGrpc;
import io.grpc.history.RequestOperateSql;
import io.grpc.history.ResponseOperateSql;
import io.grpc.stub.StreamObserver;
import lombok.NonNull;
import net.shopin.history.enitty.GrpcMsg;
import net.shopin.history.service.impl.IEventServiceImpl;
import net.shopin.history.common.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static net.shopin.history.common.HistoryServerContext.executorService;
import static net.shopin.history.common.HistoryServerContext.tableMap;
import static net.shopin.history.enitty.GrpcEnum.*;

/**
 * @title: GreeterImpl
 * @description: 实现 定义一个实现服务接口的类
 * @author: qmg
 * @date: 2020/6/11 17:19
 * @version: V1.0
 */
@Component
public class GrpcListener extends GreeterGrpc.GreeterImplBase {
    @Autowired
    private IEventServiceImpl listener;
    /**
     * 接收传递过来的消息放入队列
     *
     * @param req
     * @param responseObserver
     */
    @Override
    public void sendOptSql(RequestOperateSql req, StreamObserver<ResponseOperateSql> responseObserver) {
        ResponseOperateSql reply = null;
        //解析消息 获取操作表名
        GrpcMsg msg = GsonUtil.getClass(req.getName(), GrpcMsg.class);
        switch (msg.getType()) {
            case REFRESH:
                reply = toRefreshEvent(msg);
                break;
            case INSERT:
                reply = toInsertEvent(msg);
                break;
            case OK:
                break;
            default:
                System.out.println("未知标志：" + msg.getType());
                break;
        }
        reply = reply == null ? ResponseOperateSql.newBuilder().setMessage(FAIL.toString()).build() : reply;
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    /**
     * 历史记录落库
     * @param msg
     * @return
     */
    private ResponseOperateSql toInsertEvent(GrpcMsg msg) {
        @NonNull String tableName = msg.getTableName();
        //数据库表 存在 且可工作
        if (tableMap.containsKey(tableName) && tableMap.get(tableName)) {
            executorService.submit(() -> {
                listener.queueEventListener(msg);
            });
            return ResponseOperateSql.newBuilder().setMessage(OK.toString()).build();

        }
        listener.saveRequestRecord(msg);
        return ResponseOperateSql.newBuilder().setMessage(REFRESH.toString()).build();
    }




    private ResponseOperateSql toRefreshEvent(GrpcMsg msg) {
        executorService.submit(() -> {
            listener.queueEventListener(msg);
        });
        //TODO 获取暂存数据放入任务池
        return ResponseOperateSql.newBuilder().setMessage(OK.toString()).build();
    }

}
