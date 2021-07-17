package com.mphasis.main.cui;




public class Main {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
         Runnable task = new Runnable() {
             @Override
             public void run() {
                 Thread currThread = Thread.currentThread();
                 for (int counter = 0; counter < 10; counter++) {
                     System.out.println(currThread + String.valueOf(counter));
                 }
             }
         };


            Thread thread1 = new Thread(task, "thread1");
            Thread thread2 = new Thread(task, "thread2");


        thread1.start();
        thread2.start();
        System.out.println(thread1.getState());
        try

            {
                thread1.join();
                thread2.join();
            } catch(
            InterruptedException e)

            {
                e.printStackTrace();
            }
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

        System.out.println("end");
        };
}
