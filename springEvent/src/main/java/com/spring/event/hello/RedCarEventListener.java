package com.spring.event.hello;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:08:57 
 * 类说明   无序事件监听器
 */
@Component
public class RedCarEventListener implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof TrafficLightEvent) {
			System.out.println("红色汽车接收到信号："+event.getSource());
		}
	}
}
