package com.threads.lesson8;

/**
 * Deadlock - несколько потоков пытаются запустить 2 синхронизированных  ресурса,
 * которые ссылаются друг на друга(в итоге 2 ресурса заблокированны).
 */
public class Main {
    public static void main(String[] args) {
            FirstResource firstResource = new FirstResource();
            SecondResource secondResource = new SecondResource();
            firstResource.secondResource = secondResource;
            secondResource.firstResource = firstResource;
            FirstThread firstThread = new FirstThread();
            SecondThread secondThread = new SecondThread();
            firstThread.firstResource = firstResource;
            secondThread.secondResource = secondResource;
            firstThread.start();
            secondThread.start();


    }
}

class FirstThread extends Thread {

    FirstResource firstResource;

    @Override
    public void run() {
        System.out.println(firstResource.getSecondResource());
    }
}

class SecondThread extends Thread {

    SecondResource secondResource;

    @Override
    public void run() {
        System.out.println(secondResource.getFirstResource());
    }
}


class FirstResource {
    SecondResource secondResource;

    public synchronized int getSecondResource() {
        return secondResource.returnSecondResource();
    }

    public synchronized int returnFirstResource() {
        return 1;
    }
}

class SecondResource {
    FirstResource firstResource;

    public synchronized int getFirstResource() {
        return firstResource.returnFirstResource();
    }

    public synchronized int returnSecondResource() {
        return 2;
    }
}
