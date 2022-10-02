package com.threads.example2.notifyAll;

public class Thread2 extends Thread{

    private Manager manager;

    public Thread2(Manager manager){
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.startAfterWaiting();
    }
}
