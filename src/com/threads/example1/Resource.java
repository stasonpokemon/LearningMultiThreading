package com.threads.example1;

public class Resource {

    public static final int COUNT = 5;
    private int value;
    private boolean busy;


    public synchronized void put(int value) {
        if (busy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = true;
        System.out.println("PUT: " + value);
        this.value = value;
        notifyAll();
    }

    public synchronized int get() {
        if (!busy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        busy = false;
        notifyAll();
        System.out.println("GET: " + value);
        return value;
    }

}
