package com.threads.lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 /**
 * synchronized collections всё рано лучше синхронизировать synchronize
 */

public class Main {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("first");
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        new MyThread().start();
        new MyThread().start();
    }

    static class NameList {
        private List<String> list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        /**
         * Тут есть вероятность exception, поэтому лучше сихронизировать метод или блок synchronize !!!
         */
        public String removeFirst() {
            if (list.size() > 0) {
                return list.remove(0);
            }
            return null;
        }
    }
}
