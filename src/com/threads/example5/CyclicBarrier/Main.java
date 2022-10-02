package com.threads.example5.CyclicBarrier;

/**
 * About CyclicBarrier
 * */
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(3);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread1(cyclicBarrier1, cyclicBarrier2).start();
        }

    }
}
