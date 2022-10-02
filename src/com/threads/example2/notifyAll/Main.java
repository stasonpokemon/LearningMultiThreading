package com.threads.example2.notifyAll;

/**
 * About notifyAll()
 * */

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        for (int i = 0; i < 5; i++) {
            new Thread1(manager).start();
        }
        new Thread2(manager).start();
    }
}
