package com.spring.event.hello;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:15:10 
 * 类说明  有序事件监听器
 */
@Component
public class BusCarListener implements SmartApplicationListener{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("公交车接收到信号: "+event.getSource());
	}

	public int getOrder() {
		return 2;
	}

	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == TrafficLightEvent.class;
	}

	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == String.class;
	}

}
