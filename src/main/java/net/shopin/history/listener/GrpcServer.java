package net.shopin.history.listener;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import net.shopin.history.common.HistoryServerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @title: GrpcServer
 * @description: rpc 消息传递服务
 * @author: qmg
 * @date: 2020/6/11 16:14
 * @version: V1.0
 */
@Component
public class GrpcServer  implements ApplicationRunner {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());
    private Server server;

    @Autowired
    private GreeterImpl greeter;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.start();
        this.blockUntilShutdown();
    }













    //======================rpc 服务=================================================
    /**
     * 开启端口监听
     * @throws IOException
     */
    public void start() throws IOException {
        server = ServerBuilder.forPort(HistoryServerContext.PORT)
                .addService(greeter)
                .build()
                .start();
        logger.info("服务启动完成, 开启端口监听： "+ HistoryServerContext.PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run(){
                System.err.println("*** 应用停止,关闭rpc监听");
                GrpcServer.this.stop();
                System.err.println("*** 服务关闭");
            }
        });
    }

    /**
     * block 一直到退出程序
     * @throws InterruptedException
     */
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }

    /**
     * 停止监听
     */
    private void stop(){
        if (server != null){
            server.shutdown();
        }
    }
}
