package com.threads.example5.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread1 extends Thread {

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public Thread1(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start 1");
            Thread.sleep(1000 + (int) (Math.random() * 4000));
            System.out.println(Thread.currentThread().getName() + " waiting at a barrier 1");
            // Когда каждый поток дойдёт до даннаго борьера, то только потом они смогут продолжить выполнение данного метода
            barrier1.await();

            System.out.println(Thread.currentThread().getName() + " start 2");
            Thread.sleep(1000 + (int) (Math.random() * 4000));
            System.out.println(Thread.currentThread().getName() + " waiting at a barrier 2");
            // Когда каждый поток дойдёт до даннаго борьера, то только потом они смогут продолжить выполнение данного метода
            barrier2.await();
            System.out.println(Thread.currentThread().getName() + " done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
