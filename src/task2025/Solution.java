package com.javarush.task.task20.task2025;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Алгоритмы-числа
*/
public class Solution {

    private static long[][] powerMatrix;
    private static int[] powersOf10;
    private static List<Long> resultList = new ArrayList<>();

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/ (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

    public static long[] getNumbers(long N) {
        resultList.clear();
        int size = String.valueOf(N - 1).length();
//        System.out.println(size);

        if (N < 0) return new long[0];


        powerMatrix = new long[10][size+1];
        for (int digit = 0; digit < 10L; digit++) {
            for (int power = 0; power <= size; power++) {
                powerMatrix[digit][power] = new BigInteger(String.valueOf(digit)).pow(power).longValue();
//                        powerMatrix[digit][power] = (long) StrictMath.pow(digit, power);
            }
        }
        powerMatrix[0][0] = 0;

//        initialize(size);

        if (size > 0) {
            for (long i = 1; i < 10; i++) {
                resultList.add(i);
            }
        }
        if (size > 1) {
            for (int i = 2; i <= size; i++) {
                processNumbers(new int[i], i);
            }
        }

//        resultList = resultList.stream().filter((element) -> element < N).collect(Collectors.toList());

        for (Long number : new ArrayList<>(resultList)) {
            if (number >= N) resultList.remove(number);
        }

        long[] result = new long[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
//            System.out.println(result[i]);
        }
        Arrays.sort(result);
//        System.out.println(isArmstrongNumber(1517841543307505039L, 19));
//        int[] ndig = {9, 9, 8, 7, 6, 6, 5, 5, 5, 5, 3, 3, 2, 2, 0, 0, 0};
//        long s = 0;
//        for (int i =0; i < 17; i++) s += powerMatrix[ndig[i]][17];
//        System.out.println(powerMatrix[9][17]);
//        System.out.println(s);
//        System.out.println(result.length);
        return result;
    }



    public static void processNumbers(int[] digits, int arraySize) {

//        System.out.println(digits.length);
//        System.out.println(arraySize);

        while (digits[arraySize - 1] < 10) {
            checkNumbers(digits, arraySize);
            for (int i = 0; i < arraySize - 1; i++) {
//            digits[i]++;
                if (digits[i] > 9) {
                    digits[i] = 0;
                    digits[i + 1]++;
                }
            }

            for (int i = arraySize - 1; i > 0; i--) {
                if (digits[i] > digits[i - 1]) digits[i - 1] = digits[i];
            }

        }

//        if (digits[arraySize - 1] > 9) return;



//        checkNumbers(digits);

//        for (int i = 0; i < powerMatrix.length; i++) {
//            for (int j = 0; j < powerMatrix[0].length; j++) {
//                System.out.print(powerMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }

//        long sum1 = 0, sum2 = 0;
//        for (int i = 0; i < arraySize; i++) {
//            sum1 += powerMatrix[digits[i]][arraySize];
//            sum2 += powersOf10[i] * digits[i];
//        }
//
//        if (sum1 == sum2) {
//            resultList.add(sum1);
//            System.out.println(sum1);
//        }

    }

    public static void checkNumbers(int[] digits, int arraySize) {

        long sum;
//        int size = digits.length;

        while (digits[0] < 10) {
//            System.out.println(Arrays.toString(digits));
            sum = 0;

            for (int i = 0; i < arraySize; i++) {
                sum += powerMatrix[digits[i]][arraySize];
            }

//            if (sum == 35875699062250035L) {
//                System.out.println(isArmstrongNumber(sum, arraySize) + ": " + sum + ",  " + arraySize);
//                System.out.println(Arrays.toString(digits));
//            }

//            System.out.println(sum1 + " " + sum2);

//            if (sum == 4150) System.out.println(Arrays.toString(digits));
            if (isArmstrongNumber(sum, arraySize) && !resultList.contains(sum) && sum != 0) resultList.add(sum);
            digits[0] ++;
        }

    }

//    private static void initialize(int size) {
//
//
////        powersOf10 = new int[size];
////        for (int i = 0; i < size; i++) powersOf10[i] = (int) StrictMath.pow(10, i);
//    }

    private static boolean isArmstrongNumber(long initNumber, int size) {

        long number = initNumber;
        long sum = 0L;
        while (number > 0) {
            long currentDigit = number % 10;
            sum += powerMatrix[(int)currentDigit][size];//StrictMath.pow(currentDigit, size);
            number /= 10;
        }
//        System.out.println(initNumber + " " + sum);
        return sum == initNumber && String.valueOf(initNumber).length() == size;
    }
}
