package com.mphaiss.main.cui;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class Task implements Runnable{
    CyclicBarrier latch;
    String name;
    int duration;

    public Task(CyclicBarrier latch, String name, int duration) {
        this.latch = latch;
        this.name = name;
        this.duration = duration;
    }

    public Task(CyclicBarrier latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        Logger.getLogger(Task.class.getName()).log(Level.INFO, "Starting...");

        System.out.println(Thread.currentThread());
        System.out.println("Rseuming...");
    }
}
public class Main {

    public static void main(String[] args) {
        int vCPU = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(vCPU);

       CyclicBarrier latch = new CyclicBarrier(3);
        service.execute(new Task(latch,"Task1", 2000));
        service.execute(new Task(latch,"Task2", 4000));
        service.execute(new Task(latch,"Task3", 6000));
        Logger.getLogger(Main.class.getName()).log(Level.INFO, "End of main");

        service.shutdown();
    }
}
