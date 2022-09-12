package com.threads.lesson4;


/**
 * synchronization of static methods
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource.i = 5;


        FirstThread firstThread = new FirstThread();
        FirstThread firstThread2 = new FirstThread();
        firstThread.start();
        firstThread2.start();
        firstThread.join();
        firstThread2.join();

        System.out.println(Resource.i);
    }
}
