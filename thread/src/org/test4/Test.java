package org.test4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Test {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String input = queue.take();
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName() + ":" + output);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 10; i++) { // 这行不能改动
            String input = i + ""; // 这行不能改动
            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
