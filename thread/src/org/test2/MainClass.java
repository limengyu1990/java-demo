package org.test2;

public class MainClass {
    public static void main(String[] args) {
        Thread thread =  new Thread(new Counter());
        
        thread.start();
    }
}
