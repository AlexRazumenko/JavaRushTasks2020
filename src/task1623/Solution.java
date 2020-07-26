package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());

    }

    public static class GenerateThread extends Thread {

        public GenerateThread () {
            super(String.valueOf(++createdThreadCount));
//            createdThreadCount++;

            start();
        }

        @Override
        public void run() {
            if (createdThreadCount < count) {
            Thread t = new GenerateThread();
                System.out.println(t);
            }

        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
