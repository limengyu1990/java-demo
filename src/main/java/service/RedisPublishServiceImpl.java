package com.ikang.appService.exp.service;

import com.ikang.appService.api.service.redis.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/6.
 */
@Service("publishService")
public class RedisPublishServiceImpl implements PublishService {

    private static final String GUIDE_CHANNEL = "guide_channel";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void publishMessage(String message, String topic) {
        stringRedisTemplate.convertAndSend(GUIDE_CHANNEL,message);
    }
}
