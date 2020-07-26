package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String obj = null;
        boolean isObjPresent = false;

        int i = input.indexOf("?");
        String[] parameters = input.substring(i+1).split("&");

        for (String s : parameters) {
            String val;
            if (s.contains("=")) {
                val = s.substring(0, s.indexOf("="));
                if (val.equals("obj")) {
                    isObjPresent = true;
                    obj = s.substring(s.indexOf("=") + 1);
                }
            } else val = s;
            System.out.print(val + " ");
        }
        System.out.print("\n");

        if (isObjPresent) {
            try {
                Double d = Double.parseDouble(obj);
                alert(d);
            } catch (NumberFormatException e) {
                alert(obj);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}


//  http://javarush.ru/alpha/index.html?lvl=15&view&obj=tram&name=Amigo
//  http://javarush.ru/alpha/index.html?lvl=15&view&obj=12.2&name=Amigo