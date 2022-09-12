package com.threads.lesson1;

public class FirstThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++){
            System.out.println("Thread " + Thread.currentThread().getName() + ":  - " + i);
        }
    }
}
