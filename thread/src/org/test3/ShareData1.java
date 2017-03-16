package org.test3;

public class ShareData1 {
    public ShareData1() {
    }

    private int j = 0;
    private int i = 0;

    public synchronized void increment() {
        j++;
        System.out.println(Thread.currentThread().getName()+"+++++:"+j);
    }

    public synchronized void decrement() {
        i--;
        System.out.println(Thread.currentThread().getName()+"------:"+i);
    }
}
