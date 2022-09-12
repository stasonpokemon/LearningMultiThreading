package com.threads.lesson4;

public class Resource {

    static int i;

    /**
     * СТАТИЧЕСКАЯ СИНХРОНИЗАЦИЯ СИНХРОНИЗИРУЕТ НА УРОВНЕ КЛАССА КАК ВО ВТОРОМ МЕТОДЕ С БЛОКОМ
     *
     * !!! НИКОГДА НЕЛЬЗЯ СОВМЕЩАТЬ СТАЧИЧЕСКУЮ И ОБЪЕКТНУЮ СИНХРОНИЗАЦИЮ
     *
     * Если 1 поток прервётся в середине метода, то,
     * благодаря synchronized, 2 поток не сможет войти в метод
     * пока 1 поток не закончит работу с этим методом
     **/

    public synchronized static void changeStaticI() {
        int i = Resource.i;
        i++;
        Resource.i = i;
    }

    public static void changeStaticIWithBlock() {
        synchronized (Resource.class) {
            int i = Resource.i;
            i++;
            Resource.i = i;
        }
    }

}
