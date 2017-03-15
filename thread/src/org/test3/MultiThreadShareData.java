package org.test3;

public class MultiThreadShareData {
    
    public static void main(String[] args) {
        ShareData1 data2 = new ShareData1();
        for(int i=0;i<10;i++){
            new Thread(new MyRunnable1(data2)).start();
            new Thread(new MyRunnable2(data2)).start();
        }
       
        final ShareData1 data1 = new ShareData1();
//        new Thread(new Runnable() {
//            public void run(){
//                data1.decrement();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            public void run() {
//                data1.increment();
//            }
//        }).start();
    }

  
}
