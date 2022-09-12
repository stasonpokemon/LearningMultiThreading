package com.threads.lesson2;

public class FirstThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
