package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<Throwable> list = new ArrayList<>();

        while (e != null) {
            list.add(0, e);
            e = e.getCause();
        }
        for (Throwable th : list) System.out.println(th.getClass().getName() + ": " + th.getMessage());
    }

    public static void main(String[] args) throws Exception {

        Thread.setDefaultUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

    }
}
