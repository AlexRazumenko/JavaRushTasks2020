package task3009;

/* 
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String numberStr) {
        Set<Integer> palyndromeNumbersSet = new HashSet<>();
        int number;

        try {
            number = Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            return palyndromeNumbersSet;
        }

        for (int i = 2; i < 37; i++) {
            try {
                String radixNum = Integer.toString(number, i);
                if (radixNum.equals(new StringBuilder(radixNum).reverse().toString()))
                    palyndromeNumbersSet.add(i);
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return palyndromeNumbersSet;
    }
}