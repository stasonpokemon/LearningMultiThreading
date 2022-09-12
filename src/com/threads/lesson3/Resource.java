package com.threads.lesson3;

public class Resource {

    private int i;
    private int y;

    /**
     * Если 1 поток прервётся в середине метода, то,
     * благодаря synchronized, 2 поток не сможет войти в метод
     * пока 1 поток не закончит работу с этим методом
     **/
    public synchronized void changeI() {
        int i = this.i;
        i++;
        this.i = i;
    }

    /**
     * Так же при помощи synchronized можно синхронизировать отдельные блоки кода
     */
    public void changeY() {
        synchronized (this) {
            int i = this.i;
            i++;
            this.i = i;
        }
    }

    public int getI() {
        return i;
    }

    /**
     * Методы set так же должны быть synchronized!!!
     * */
    public synchronized void setI(int i) {
        this.i = i;
    }

    public int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }
}
