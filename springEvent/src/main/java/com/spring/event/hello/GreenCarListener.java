package com.spring.event.hello;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:13:03 
 * 类说明  无序事件监听器
 */
@Component
public class GreenCarListener implements ApplicationListener<TrafficLightEvent>{

	public void onApplicationEvent(TrafficLightEvent event) {
		System.out.println("绿色汽车接收到信号: "+event.getSource());
		
	}

}
