package com.threads.example4.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * About CountDownLatch
 * */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int N = 5;
        // Конструктор принимает количество стеночек
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; i++) {
            new Thread1(startSignal, doneSignal).start();
        }

        doSmth(1);
        // Убираем одну стеночку и даём потокам разрешение на продолжение работы
        startSignal.countDown();
        // Ждём пока наши потоки уберут все стеночки, чтомы мы смогли продолжить выполнение метода
        doneSignal.await();
        doSmth(2);
    }

    private static void doSmth(int phase) {
        try {
            Thread.sleep(2000);
            System.out.println("do something done: " + phase);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
