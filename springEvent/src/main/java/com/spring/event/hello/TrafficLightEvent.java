package com.spring.event.hello;

import org.springframework.context.ApplicationEvent;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:02:21 
 * 类说明  定义TrafficLight事件(交通灯事件)
 */
public class TrafficLightEvent extends ApplicationEvent{
	
	public TrafficLightEvent(String source) {
		super(source);
	}
}
