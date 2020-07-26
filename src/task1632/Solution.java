package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new NewThread1());
        threads.add(new NewThread2());
        threads.add(new NewThread3());
        threads.add(new NewThread4());
        threads.add(new NewThread5());
    }

    public static void main(String[] args) {
        for (Thread t : threads) t.start();
    }


    public static class NewThread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class NewThread2 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class NewThread3 extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class NewThread4 extends Thread implements Message {

        boolean b = true;

        @Override
        public void run() {

            while (b) {

            }
        }

        @Override
        public void showWarning() {
            b = false;
        }
    }

    public static class NewThread5 extends Thread {
        @Override
        public void run() {
            int sum = 0;
            Scanner scanner = new Scanner(System.in);
            String input = "";

            while (true) {
                try {
                    input = scanner.nextLine();
                    if (input.equals("N")) break;
                    int a = Integer.parseInt(input);
                    sum += a;
                } catch (NumberFormatException e) {
                    continue;
                }


            }

            System.out.println(sum);

        }
    }


}