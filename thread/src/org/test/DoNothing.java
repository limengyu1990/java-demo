package org.test;

public class DoNothing {
    
    public static void doNothing(){
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+":====:"+i);
        }
    }
}
