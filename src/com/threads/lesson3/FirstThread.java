package com.threads.lesson3;

public class FirstThread extends Thread{

    Resource resource;

    @Override
    public void run() {
        resource.changeI();
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
