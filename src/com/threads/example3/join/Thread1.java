package com.threads.example3.join;

public class Thread1 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread 1 started");
            Thread2 thread2 = new Thread2();
            thread2.start();
            thread2.join();
            System.out.println("Thread 1 done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
