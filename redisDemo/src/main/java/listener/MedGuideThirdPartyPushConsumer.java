package com.ikang.appService.exp.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MedGuideThirdPartyPushConsumer implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MedGuideThirdPartyPushConsumer.class);


    @Override
    public void onMessage(Message message, byte[] pattern){
        String receiveMessage = new String(message.getBody());
        System.out.println("收到消息[第三方]channel:" + new String(message.getChannel())+ ",message:" + receiveMessage);
    }
}
