package com.threads.lesson6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic variables - не позволяет потокам несанционированно изменять переменную
 */


public class Main {

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10000; j++) {
            new FirstThread().start();
        }
        Thread.sleep(2000);
        System.out.println(atomicInteger.get());
    }


    static class FirstThread extends Thread {
        @Override
        public void run() {
            atomicInteger.decrementAndGet();
        }
    }
}
