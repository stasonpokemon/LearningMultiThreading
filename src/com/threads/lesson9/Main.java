package com.threads.lesson9;

/**
 * Wait - освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
 * пока другой поток не вызовет метод notify()
 *
 * Notify - notify(): продолжает работу потока,
 * у которого ранее был вызван метод wait()
 *
 * !!! ЭТИ ДВА МЕТОДА ОБЯЗАТЕЛЬНО ДОЛЖНЫ ВЫХЫВАТЬСЯ ИЗ synchronized КОНТЕКСТА !!!
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        synchronized (threadA) {
            threadA.wait();
        }
        System.out.println(threadA.total);
    }

    static class ThreadA extends Thread {
        int total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    total += i;
                }
                notify();

            }
        }
    }
}
