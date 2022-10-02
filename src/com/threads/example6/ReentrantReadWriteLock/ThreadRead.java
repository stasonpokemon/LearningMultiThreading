package com.threads.example6.ReentrantReadWriteLock;

public class ThreadRead extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < Main.COUNT; i++) {
            if (Main.lock.isWriteLocked()){
                System.out.println("Lock for writing");
            }
            // Создаётся блокировка для чтения(разрешено читать всем потокам, а писать нельзя никому)
            Main.lock.readLock().lock();
            try {
                System.out.println("Reading...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ReadThread " + Thread.currentThread().getId() + " -----> Message is " + Main.message);
            // Разблоктрование блокировки для чтения(разрешено читать и писать всем потокам)
            Main.lock.readLock().unlock();
        }
    }
}
