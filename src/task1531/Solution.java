package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {

        BigInteger result = new BigInteger("1");
        BigInteger a = new BigInteger("1");
        if (n > 150) n = 150;
        if (n < 0) return "0";
        if (n == 0) return "1"; //result = 1.0;
        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                a = BigInteger.valueOf(i);
                result = result.multiply(a);
            }
        }
        return result.toString();
    }
}
