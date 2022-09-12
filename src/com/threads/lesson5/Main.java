package com.threads.lesson5;

/**
 * volatile - не кеширует значения в потоках
 */

public class Main {

    volatile static int i = 0;

    public static void main(String[] args) {
        new ReadThread().start();
        new WriteThread().start();
    }

    static class WriteThread extends Thread {

        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReadThread extends Thread {

        @Override
        public void run() {
            int localI = i;
            while (localI < 5) {
                if (localI != i){
                    System.out.println("new value of i is " + i);
                    localI = i;
                }
            }
        }
    }
}

