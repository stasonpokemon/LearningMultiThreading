package com.threads.example2.notifyAll;

public class Manager {

    public synchronized void methodWait() {
        System.out.println("Thread is waiting: " + Thread.currentThread().getId());
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tread is done: " + Thread.currentThread().getId());
    }

    public synchronized void startAfterWaiting() {
        System.out.println("Start all threads");
        notifyAll();
    }

}
