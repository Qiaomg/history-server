package net.shopin.history.listener;

import io.grpc.history.GreeterGrpc;
import io.grpc.history.RequestOperateSql;
import io.grpc.history.ResponseOperateSql;
import io.grpc.stub.StreamObserver;
import lombok.NonNull;
import net.shopin.history.enitty.GrpcMsg;
import net.shopin.history.enitty.RequestRecord;
import net.shopin.history.mapper.RequestRecordMapper;
import net.shopin.history.service.impl.QueueEventListener;
import net.shopin.history.common.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static net.shopin.history.common.HistoryServerContext.executorService;
import static net.shopin.history.common.HistoryServerContext.tableMap;
import static net.shopin.history.enitty.GrpcTypeEnum.*;

/**
 * @title: GreeterImpl
 * @description: 实现 定义一个实现服务接口的类
 * @author: qmg
 * @date: 2020/6/11 17:19
 * @version: V1.0
 */
@Component
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Autowired
    private QueueEventListener listener;
    @Autowired
    private RequestRecordMapper requestRecordMapper;

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
            case CREATE:
//                reply = toCreateEvent(msg);
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


    private ResponseOperateSql toInsertEvent(GrpcMsg msg) {
        @NonNull String tableName = msg.getTableName();
        if (!tableMap.containsKey(tableName)) {
            RequestRecord rr = new RequestRecord();
            rr.setCreateTime(new Date());
            rr.setType(msg.getType().toString());
            rr.setTableName(msg.getTableName());
            rr.setServerName(msg.getServerName());
            rr.setOptSql(msg.getOptSql());
            requestRecordMapper.insert(rr);
            return ResponseOperateSql.newBuilder().setMessage(CREATE.toString()).build();
        }
        executorService.submit(() -> {
            listener.queueEventListener(msg);
        });
        return ResponseOperateSql.newBuilder().setMessage(OK.toString()).build();
    }



    private ResponseOperateSql toCreateEvent(GrpcMsg msg) {
        executorService.submit(() -> {
            listener.queueEventListener(msg);
        });
        //TODO 获取暂存数据放入任务池
        return ResponseOperateSql.newBuilder().setMessage(OK.toString()).build();
    }

}
