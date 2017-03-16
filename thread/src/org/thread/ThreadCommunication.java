package org.thread;

/**
 * 线程同步通讯
 * demo：子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次
 * 
 * 如果一个线程访问某个类的同步方法的时候，如果在方法体中没有调用wait()方法，
 * 那么其他线程不可以访问这个类的其他所有同步方法（静态的除外）
 * @author limengyu
 * 2014-5-10 下午04:17:21
 */
public class ThreadCommunication {
    
    public static void main(String[] args) {
        
        final Business bus = new Business();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=50;i++){
                    bus.sub(i);
                }
            }
        }).start();
        
        for(int i=1;i<=50;i++){
            bus.main(i);
        }
    }
}

/**
 * 要用到共同数据（包括同步锁）的若干方法应该归在同一个类身上，就如同一个加密解密工具类一样
 * @author limengyu
 * 2014-5-10 下午04:23:44
 */
class Business{
    
    private boolean flag = true;
    /**
     * 子线程
     * 2014-5-10
     * 下午04:28:16
     * @param n
     */
    public synchronized void sub(int s) {
        while(!flag){ //如果不该子线程运行的话，子线程就等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //子线程循环10次
        for(int i=1;i<=10;i++){
            System.out.println("s:"+s+"---"+Thread.currentThread().getName()+"----i:"+i);
        }
        flag = false;   
        this.notify();  //唤醒主线程
    }
    
    /**
     * 主线程
     * 2014-5-10
     * 下午04:28:41
     */
    public synchronized void main(int m) {
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //主线程循环100次
        for(int i=1;i<=100;i++){
            System.out.println("m:"+m+"---"+Thread.currentThread().getName()+"----i:"+i);
        }
        flag = true;
        this.notify();
    }
}
