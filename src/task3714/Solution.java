package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {

        List<Character> romanDigitsList = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');
        int size = s.length();

        int[] digits = new int[size];
        s = s.toUpperCase();
        for (int i = 0; i < size; i++) {
            char romanDigit = s.charAt(i);
            if (romanDigitsList.contains(romanDigit)) {
                int number = RomanDigits.valueOf(String.valueOf(romanDigit)).getValue();
                digits[i] = number;
            }
        }

        int result = 0;
        for (int i = 0; i < size - 1; i++) {
            if (digits[i] < digits[i + 1]) result += (-1 * digits[i]);
            else result += digits[i];
        }
        result += digits[size - 1];
        return result;
    }

    public enum RomanDigits {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

        private int value;

        RomanDigits(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
