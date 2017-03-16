package com.ikang.appService.exp.listener;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 监听下一站导检消息
 * Created by Administrator on 2017/3/6.
 */
public class NextMedGuideConsumer implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] pattern){
        System.out.println("收到消息channel:" + new String(message.getChannel())+ ",message:" + new String(message.getBody()));
    }
}
