package com.spring.event.hello;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:28:54 
 * 类说明 
 */
@Component
public class YellowCarListener implements ApplicationListener<TrafficLightEvent>{

	public void onApplicationEvent(TrafficLightEvent event) {
		System.out.println("黄色汽车接收到信号: "+event.getSource());
	}
}
