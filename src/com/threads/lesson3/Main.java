package com.threads.lesson3;

/**
 * synchronization
 * */

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Resource resource = new Resource();
        resource.setI(5);


        FirstThread firstThread = new FirstThread();
        FirstThread firstThread2 = new FirstThread();
        firstThread.setResource(resource);
        firstThread2.setResource(resource);
        firstThread.start();
        firstThread2.start();
        firstThread.join();
        firstThread2.join();

        System.out.println(resource.getI());
    }
}
