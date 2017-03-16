package org.test3;


class MyRunnable2 implements Runnable {
    private ShareData1 data1;

    public MyRunnable2(ShareData1 data1) {
        this.data1 = data1;
    }

    public void run() {
        data1.increment();
    }
}
