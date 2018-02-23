package com.javarush.task.task34.task3405;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/* 
Мягкие ссылки
*/
public class Solution {
    public static Helper helper = new Helper();
    private static Runtime runtime= Runtime.getRuntime();
    private static void printFreeMemory(){
        System.out.printf("Свободной памяти сейчас %,12d%n",Runtime.getRuntime().freeMemory());
    }

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() {

            printFreeMemory();
            System.out.println("Сработал finalize()\n");
//            Helper.isFinalized = true;
//            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();


        printFreeMemory();
        System.out.println("Создаем объект Monkey\n");
        Monkey monkey = new Monkey("Simka");
        SoftReference<Monkey> reference = new SoftReference<>(monkey);

        printFreeMemory();
        System.out.println("Удаляем сильную ссылку на Monkey\n");
        monkey = null;

        printFreeMemory();
        System.out.println("Запуск очистки\n");
        helper.callGC();

        Thread.sleep(1000);
        printFreeMemory();
        System.out.println("Загружаем хип\n");
        helper.heapConsuming();

        printFreeMemory();
        System.out.println("Вышли из загрузки хипа\n");

//        if (reference.get() == null)
//            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;
        List<Solution> heap = new ArrayList<>(100000);
        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        void heapConsuming() {
            try {

                while (!isFinalized) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                printFreeMemory();
                System.out.println("Сгенерировалось OutOfMemoryError\n");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " sec");
        }
    }
}
