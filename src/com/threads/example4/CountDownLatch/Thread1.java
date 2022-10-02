package com.threads.example4.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Thread1 extends Thread {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Thread1(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread is waiting for start");
            // Остановка потока и ожидание разрешения для продолжения работы
            startSignal.await();
            doWork();
            // Отдаёт отчёт о том, что поток выполним свою работу(убираем стеночку)
            doneSignal.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        System.out.println("Thread done");
    }
}
