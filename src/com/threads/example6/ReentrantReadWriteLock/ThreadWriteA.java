package com.threads.example6.ReentrantReadWriteLock;

public class ThreadWriteA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Main.COUNT; i++) {
            try {
                // Создаётся блокировка для записи(запрещено читать всем потокам, писать можно только ОДНОМУ потоку)
                Main.lock.writeLock().lock();
                System.out.println("I take the lock for 'a'");
                Main.message = Main.message.concat(" a");
                System.out.println("I edited message");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Разблоктрование блокировки для записи(разрешено читать и писать всем потокам)
                Main.lock.writeLock().unlock();
            }
        }
    }
}
