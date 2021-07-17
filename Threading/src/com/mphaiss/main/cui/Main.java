package com.mphaiss.main.cui;
class Data{
    private int value;



    public void getValue() {
        System.out.println(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
class Task implements Runnable{
    Data data;

    public Task(Data data) {
        this.data = data;
    }

    public Task() {
    }

    @Override
    public void run() {
        for (int counter=0;counter<10;counter++){
            Thread currThread = Thread.currentThread();
            System.out.println(currThread);
            if (currThread.getName().equals("Producer")){
                synchronized (data) {//lock acquired
                    data.setValue(counter);
                    try {
                        data.notify();
                        data.wait();//we are controlling the lock release
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//lock released
            }else if(currThread.getName().equals("Consumer")){
                synchronized (data) {//lock acquired
                    data.getValue();
                    try {
                        data.notify();
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//lock released
            }

        }
    }
}
public class Main {

    public static void main(String[] args) {

        Data data = new Data();
        Task task = new Task(data);
        Thread thread1 = new Thread(task, "Producer");
        Thread thread2 = new Thread(task, "Consumer");
        thread1.start();
        thread2.start();
        System.out.println("END");
    }
}
