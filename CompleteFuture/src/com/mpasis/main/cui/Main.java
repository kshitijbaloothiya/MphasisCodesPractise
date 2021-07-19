package com.mpasis.main.cui;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger logger;
    static {
        logger = Logger.getLogger(Main.class.getName());
    }
   /* public static void process(CompletableFuture<Integer> completableFuture){

        logger.log(Level.INFO, "Begin");
        completableFuture
                        .thenApply((data) -> (data+4))
                        .thenApply((data) -> (data/0))
                        .exceptionally(throwable -> handle(throwable))
                        .thenAccept((data) -> System.out.println(Thread.currentThread().toString()+"\nData:"+data))
                        .thenRun(() -> System.out.println("task1"))
                        .thenRun(() -> System.out.println("task2"));
        logger.log(Level.INFO, "Ending");

    }*/
   public static CompletableFuture<Integer> create() {
       logger.log(Level.INFO, Thread.currentThread()+ " inside create");
       return CompletableFuture.supplyAsync(() -> compute());
   }

    public static Integer compute() {
       logger.log(Level.INFO, Thread.currentThread()+" inside compute");
       return 2;
    }

    public static Integer handle(Throwable throwable) {
        logger.log(Level.INFO, "Error:"+throwable);
        return 0;
    }

    public static void main(String[] args) {
       create()
               .thenApply(data -> data+2)
               .thenAccept(data -> System.out.println(data));

    }


}
