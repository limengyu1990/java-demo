package org.thread;

/**
 * 传统线程互斥技术
 * synchronized解决线程互斥问题的前提是不同线程共享同一个锁
 * @author limengyu
 * 2014-5-10 下午04:00:16
 */
public class ThreadSynchronized {

    /**
     * 2014-5-10
     * 下午03:50:44
     * @param args
     */
    public static void main(String[] args) {
        final Outputer outputer = new Outputer(); 
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output2("1111111111");
                }
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Outputer.output3("aaaaaaaaaaaa");    
                }
            }
        }).start();
    
    }

}


class Outputer{
    
    
  //使用synchronized方法解决线程安全问题
    public synchronized void output(String name){
        int leg = name.length();
        for(int i=0;i<leg;i++){
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
    
    /**
     * 使用synchronized代码块解决线程安全问题，传入的参数是多线程调用的同一个对象，
     * 上面两个线程调用都是同一个Outputer对象（this）,所以synchronized (this) 
     * 2014-5-10
     * 下午04:14:32
     * @param name
     */
    public void output2(String name){
        int leg = name.length();
        synchronized (/*this*/Outputer.class) {
            for(int i=0;i<leg;i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
    /**
     * 在使用静态方法output3(此时类要变为：static class Outputer)和普通方法output2同步时，
     * 普通方法output2应该设置成synchronized (Outputer.class)字节码对象
     * 2014-5-10
     * 下午04:15:21
     * @param name
     */
    public static synchronized void output3(String name){
        int leg = name.length();
        for(int i=0;i<leg;i++){
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }

}
