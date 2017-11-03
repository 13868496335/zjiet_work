package com.zjiet.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 模拟 队列
 * @author: Double
 * 2017/10/26 16:38
 */
@Component
public class MockQueue {

     private  String  receiveOrder;

     private  String  completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String getReceiveOrder() {
        return receiveOrder;
    }


    public void setReceiveOrder(String receiveOrder) throws  Exception {
        logger.info("收到下单信息！！！");
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.completeOrder = receiveOrder;
            logger.info("下单请求处理完毕," +receiveOrder);
        }).start();

    }



    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }

}
