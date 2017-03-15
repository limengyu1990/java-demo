package org.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.SliderUI;

public class Counter implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String currDate = sdf.format(new Date());
            System.out.println(currDate+":====:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
