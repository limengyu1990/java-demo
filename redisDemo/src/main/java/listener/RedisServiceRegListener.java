package com.ikang.appService.exp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/6.
 */
public class RedisServiceRegListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceRegListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            Map<String,String> consumersChannel = new HashMap<>();
            consumersChannel.put("medGuideConsumer","guideChannel");
            consumersChannel.put("nextMedGuideConsumer","guideNextChannel");
            consumersChannel.put("medGuideAppointmentStatusConsumer","firstMedGuideChannel");
            consumersChannel.put("medGuideMessageConsumer","firstMedGuideChannel");
            consumersChannel.put("medGuideThirdPartyPushConsumer","firstMedGuideChannel");
            RedisMessageListenerContainer redisContainer = (RedisMessageListenerContainer)event.getApplicationContext().getBean("redisContainer");
            consumersChannel.forEach((consumer, channel) -> {
                MessageListener listener = (MessageListener) event.getApplicationContext().getBean(consumer);
                ChannelTopic channelTopic = (ChannelTopic) event.getApplicationContext().getBean(channel);
                redisContainer.addMessageListener(listener, channelTopic);
            });
            logger.debug("register pub/sub channel success...");
        }
    }
}
