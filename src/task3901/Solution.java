package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if (s == null || s.isEmpty()) return 0;

        int length = s.length();
        for (int i = length; i > 0; i--) {
            for (int j = 0; j <= length - i; j++) {
                String substring = s.substring(j, j+i);
                if (isUniqueString(substring)) return substring.length();
            }
        }
        return -1;
    }

    private static boolean isUniqueString(String string) {
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            characterSet.add(string.charAt(i));
        }

        return characterSet.size() == string.length();
    }


}
