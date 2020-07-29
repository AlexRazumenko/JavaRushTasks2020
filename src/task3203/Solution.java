package com.javarush.task.task32.task3203;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
//        String result = throwable;
//      pw.write(result);
//        String line = pw.toString()
//        StringBuilder sb = new StringBuilder();
//        while ((line = ))

        pw.close();
        String res = sw.toString();
        try {
            sw.close();
            pw.close();
        } catch (IOException e) {

        }
        return res;
//                sw.getBuffer().toString();

    }
}