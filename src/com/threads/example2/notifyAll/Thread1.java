package com.threads.example2.notifyAll;

public class Thread1 extends Thread{

    private Manager manager;

    public Thread1(Manager manager){
        this.manager = manager;
    }

    @Override
    public void run() {
        manager.methodWait();
    }
}
