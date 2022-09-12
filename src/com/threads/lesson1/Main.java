package com.threads.lesson1;

public class Main {

    public static void main(String[] args) {
        new FirstThread().start();
        new Thread(new SecondThread()).start();
    }
}
