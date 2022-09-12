package com.threads.lesson1;

public class SecondThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + ":  - " + i);
        }
    }
}
