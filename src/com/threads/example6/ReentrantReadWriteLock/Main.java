package com.threads.example6.ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * About ReentrantReadWriteLock
 */

public class Main {

    // Создание общего lock
    public static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    public static final int COUNT = 5;
    public static String message = "Some message";

    public static void main(String[] args) {
        ThreadWriteA writeA = new ThreadWriteA();
        ThreadWriteB writeB = new ThreadWriteB();

        writeA.start();
        writeB.start();

        for (int i = 0; i < COUNT; i++){
            new ThreadRead().start();
        }

    }
}
