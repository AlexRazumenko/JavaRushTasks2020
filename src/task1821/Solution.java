package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fis = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fis);
        StringBuilder sb = new StringBuilder("");
        int[] chars = new int[256];

        Map<Character, Integer> charsFrequencyMap = new TreeMap<>();
        String line;
        int r;

        while ((r = br.read()) > 0) {
//            sb.append(line);
            chars[r] ++;
        }
//        char[] chars = sb.toString().toCharArray();
        br.close();
        fis.close();

        for (int i = 0; i < 256; i++) {
            if (chars[i] > 0) System.out.println((char) i + " " + chars[i]);
        }

//        for (char ch : chars) {
//            if (!charsFrequencyMap.containsKey(ch)) charsFrequencyMap.put(ch, 1);
//            else charsFrequencyMap.put(ch, charsFrequencyMap.get(ch) + 1);
//        }
//
//        for (Map.Entry<Character, Integer> entry : charsFrequencyMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

    }
}
