package com.spring.event.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @author limengyu: 
 * @version 创建时间：2016年2月18日 上午11:21:55 
 * 类说明 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class HelloTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testPublishEvent(){
		applicationContext.publishEvent(new TrafficLightEvent("hello"));
	}
	
}
