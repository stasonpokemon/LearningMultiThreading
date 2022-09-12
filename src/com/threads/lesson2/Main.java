package com.threads.lesson2;

/**
 * Thread Lifecycles
 * */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FirstThread firstThread = new FirstThread();
        firstThread.start();
        firstThread.setPriority(Thread.MAX_PRIORITY); // Даёт максимальный приоритет потоку
        firstThread.setPriority(Thread.MIN_PRIORITY); // Даёт минимальный приоритет потоку
        Thread.sleep(1000); // Текущий поток засыпает МИНИМУМ на одну секунду
        Thread.yield(); // Говорит scheduler(отвечает за распределение потоков), что может перейти в Runnable режим и отдать преоретет выполнения другим потокам
        firstThread.join(); // Указывает на то, что текущий поток не запустится, пока поток firstThread не перейдёт в состояние dead


        System.out.println(Thread.currentThread().getName());
    }
}
