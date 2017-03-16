package org.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器demo
 * @author limengyu
 * 2014-5-10 下午03:48:36
 */
public class TimerTest {
    public static void main(String[] args) {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                },1500,1000);
    }
}
