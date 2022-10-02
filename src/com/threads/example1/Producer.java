package com.threads.example1;

public class Producer implements Runnable {


    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < Resource.COUNT; i++) {
            resource.put(i);
        }
    }
}
