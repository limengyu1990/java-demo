package com.spring.event.hello;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:17:16 
 * 类说明 有序事件监听器
 */
@Component
public class BicycleListener implements SmartApplicationListener{

	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("自行车接收到信号: "+event.getSource());
	}

	public int getOrder() {
		return 1;
	}

	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == TrafficLightEvent.class;
	}

	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == String.class;
	}

}
