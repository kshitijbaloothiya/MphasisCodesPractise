package com.mphasis.main.cui;

public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        try {
            t1.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
