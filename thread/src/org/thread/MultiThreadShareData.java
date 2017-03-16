package org.thread;

/**
 * 多个线程访问共享对象和数据的方式
 * 
 * 1.将这些 Runnable对象作为某一个类 中的内部类，
 * 共享数据作为这个外部类中的成员变量，每个线程对共享数据操作方法也分配给外部类
 * 
 * 2.将共享数据封装到另外一个对象中，然后将这个对象逐一传递给各个runnable对象，
 * 每个线程对共享数据的操作也分配到那个对象身上去完成
 * 
 * 3.如果每个线程执行的代码相同，可以使用同一个 Runnable对象，这个 Runnable对象中有那个共享数据，如卖票系统
 * 
 * @author limengyu
 * 2014-5-10 下午03:15:03
 */
public class MultiThreadShareData {
    
 // private static ThreadShareData data1 = new ThreadShareData();//定义外部类的成员变量
    
    public static void main(String[] args) {
          //****第1种方式********// 
//        for(int i=0;i<10;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    data1.inc();
//                }
//            }).start();
//            
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    data1.dec();
//                }
//            }).start();
//        }
        
        //****第2种方式********//
        ThreadShareData data2 = new ThreadShareData();
        for(int i=0;i<10;i++){
            new Thread(new MyRunnable1(data2)).start();
            new Thread(new MyRunnable2(data2)).start();
        }
        
    }
}

class MyRunnable1 implements Runnable{
    private ThreadShareData data = null;
    public MyRunnable1(ThreadShareData data){
        this.data = data;
    }
    @Override
    public void run() {
        data.inc();
    }
}
class MyRunnable2 implements Runnable{
    private ThreadShareData data = null;
    public MyRunnable2(ThreadShareData data){
        this.data = data;
    }
    @Override
    public void run() {
        data.dec();
    }
}

/**
 * 封装共享数据的类
 * @author limengyu
 * 2014-5-10 下午03:24:40
 */
class ThreadShareData{
    int num = 0;
    public synchronized void inc(){
        num++ ;
        System.out.println(Thread.currentThread().getName()+"---"+num);
    }
    
    public synchronized void dec(){
        num-- ;
        System.out.println(Thread.currentThread().getName()+"===="+num);
    }
    
}
