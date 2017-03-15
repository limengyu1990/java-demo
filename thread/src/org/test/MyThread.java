package org.test;

public class MyThread extends Thread{
        @Override
        public void run() {
           //DoNothing.doNothing();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
