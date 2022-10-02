package com.threads.example3.join;

public class Thread2 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread 2 started");
        System.out.println("Thread 2 done");
    }
}
