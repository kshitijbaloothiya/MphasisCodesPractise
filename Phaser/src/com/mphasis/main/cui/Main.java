package com.mphasis.main.cui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("Begin main "+Thread.currentThread());
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Phaser phaser = new Phaser(3);
        executor.submit(new DepedentService(phaser,1000));
        executor.submit(new DepedentService(phaser,4000));
        executor.submit(new DepedentService(phaser,5000));
        executor.shutdown();
        //executor.awaitAndAdvance for countdown
        System.out.println("End of main");
    }
    static class DepedentService implements Runnable{
        Phaser phaser;
        int duration;

        public DepedentService(Phaser phaser, int duration) {
            this.phaser = phaser;
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println("Running: "+Thread.currentThread());
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting");
            phaser.arriveAndAwaitAdvance();//change to phaser.arrive
            System.out.println(Thread.currentThread()+" progress");
        }
    }
}
