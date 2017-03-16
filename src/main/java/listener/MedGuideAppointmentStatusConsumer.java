package com.ikang.appService.exp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MedGuideAppointmentStatusConsumer implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MedGuideAppointmentStatusConsumer.class);

    @Override
    public void onMessage(Message message, byte[] pattern){
        String receiveMessage = new String(message.getBody());
        System.out.println("收到消息channel:" + new String(message.getChannel()) + ",message:" + receiveMessage);
    }
}
