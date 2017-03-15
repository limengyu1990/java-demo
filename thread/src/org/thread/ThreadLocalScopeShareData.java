package org.thread;

import java.util.Random;

/**
 * ThreadLocal实现线程范围内的共享数据和共享对象
 * @author limengyu
 * 2014-5-10 下午05:14:47
 */
public class ThreadLocalScopeShareData {
    
    //目前存入一个共享数据Integer类型的数据，如果是想存入多个共享数据呢？
    //可以设计一个对象，然后将多个共享数据作为对象的属性，然后把对象保存到ThreadLocal中
    private static ThreadLocal<Integer> map = new ThreadLocal<Integer>();
    
    private static ThreadLocal<User> shareData = new ThreadLocal<User>();
    
    public static void main(String[] args) {
        for(int i =0;i<2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();//随机生成一个数字
                    //共享数据
                    map.set(data);
                    
                    //共享对象
                    User user = User.getInstance();
                    user.setId("100-"+data);
                    user.setName("李梦雨"+data);
                    shareData.set(user);
                    
                    System.out.println("线程：["+ Thread.currentThread().getName()+"]--存入数据--"+data);
                    new A().get();
                    new B().get();
                    
                }
            }).start();
        }
    }
    
    static class A{
        public void get() {
              //共享数据测试
//            int data = map.get();
//            System.out.println("A从线程["+Thread.currentThread().getName()+"]中获取到数据："+data);
            
            //共享对象测试
            User user = shareData.get();
            System.out.println("A从线程["+Thread.currentThread().getName()+"]中获取到对象数据："+user.getId()+","+user.getName());
        }
    }
    
    static class B{
        private void get() {
//            int data = map.get();
//            System.out.println("B从线程 ["+Thread.currentThread().getName()+"]中获取到数据："+data);
            
            User user = shareData.get();
            System.out.println("B从线程["+Thread.currentThread().getName()+"]中获取到对象数据："+user.getId()+","+user.getName());
        }
    }
}


/**
 * 共享数据对象
 * @author limengyu
 * 2014-5-10 下午05:32:14
 */
class User{
    private String id;
    private String name;
    private User(){}
    private static User user = null;
    private static ThreadLocal<User> threadLocal = new ThreadLocal<User>();
    
    /**
     * 加上synchronized避免在没有返回前，创建多个对象
     * 当对象是用ThreadLocal保存时，各个线程不相互影响，所以不用加synchronized
     * 饥汉式单例，调用者通过getInstance()获取到的对象实例就是当前线程上的
     */
    public static /*synchronized*/ User getInstance(){
        user = threadLocal.get();
        if(user==null){
            user = new User();
            threadLocal.set(user);
        }
        return user;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}


