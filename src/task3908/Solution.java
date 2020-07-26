package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.Map;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("joppa"));

    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.isEmpty()) return false;
        s = s.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
        }

        int sum = 0;
        for (Character ch : map.keySet()) if (map.get(ch) % 2 == 1) sum += 1;
        return sum < 2;
    }
}
