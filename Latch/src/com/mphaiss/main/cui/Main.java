package com.mphaiss.main.cui;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Task implements Runnable{

    public Task(CountDownLatch latch, int i) {
    }
    CountDownLatch latch;
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        latch.countDown();
    }
}
public class Main {

    public static void main(String[] args) {
        int vCPU = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(vCPU);
        CountDownLatch latch = new CountDownLatch(3);
        service.execute(new Task(latch, 3000));
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
