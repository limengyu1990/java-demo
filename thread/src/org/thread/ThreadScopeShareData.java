package org.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程范围内的共享数据
 * 
 * @author limengyu
 * 2014-5-10 下午04:56:22
 */
public class ThreadScopeShareData {
    
    private static Map<Thread,Integer> map = new HashMap<Thread,Integer>();
    
    public static void main(String[] args) {
        for(int i=0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    map.put(Thread.currentThread(),data);
                    System.out.println(Thread.currentThread().getName()+" haved put data:"+data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    
    static class A{
        public void get() {
            int data = map.get(Thread.currentThread());
            System.out.println("A from "+Thread.currentThread().getName()+" get Data:"+data);
        }
    }
    
    static class B{
        public void get(){
            int data = map.get(Thread.currentThread());
            System.out.println("B from "+Thread.currentThread().getName()+" get Data:"+data);
        }
    }
}
