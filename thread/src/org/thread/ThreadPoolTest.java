package org.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent 线程池使用demo
 * @author limengyu
 * 2014-5-10 下午06:12:45
 */
public class ThreadPoolTest {
    
    public static void main(String[] args) {
          //创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
//        ExecutorService threadPool = Executors.newFixedThreadPool(3);
          //创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
//        ExecutorService threadPool = Executors.newCachedThreadPool();//缓存 
          //创建一个使用单个worker线程的线程池，以无界队列方式来运行该线程，假如该线程死掉后会重新启动一个线程并继续执行任务
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newScheduledThreadPool(2);//调度
        for(int i=1;i<=10;i++){
            final int n = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=1;j<=10;j++){
                        System.out.println("线程【"+Thread.currentThread().getName()+"】--"+n+"---"+j);
                    }
                }
            });
        }
        System.out.println("all of 5 tasks have committed! ");
        //关闭启动线程
        threadPool.shutdown();
        try {
            //等待子线程结束，再继续执行下面的代码
            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all thread complete");
        
        
        
        /**
         * 用线程池启动定时器demo
         */
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("爆破成功...");    
            }
        },5,2,TimeUnit.SECONDS);
    }
}
