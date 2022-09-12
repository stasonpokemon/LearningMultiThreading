package com.threads.lesson4;


public class FirstThread extends Thread {


    @Override
    public void run() {
        Resource.changeStaticI();
    }


}
