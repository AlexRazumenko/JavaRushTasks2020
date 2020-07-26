package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException

    {
        Map<Integer, Boolean> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();

//        String fileName = "E:\\12.html";

        String openTag = "<" + args[0];
        String closeTag = "</" + args[0] + ">";
        FileReader fr = new FileReader(fileName);
        BufferedReader br1 = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line =  br1.readLine()) != null) sb.append(line);
        fr.close();
        br.close();
        br1.close();

        String s = sb.toString();
        int openIndex = -1;
        int closeIndex = 0;
        while ( (closeIndex != -1)) {
            openIndex = s.indexOf(openTag, openIndex+1);
            closeIndex = s.indexOf(closeTag, closeIndex + 1);
            if (openIndex != -1) map.put(openIndex, true);
            if (closeIndex != -1) map.put(closeIndex, false);
        }

        int nestingIndex = 0;
        boolean b;
        List<String> result = new ArrayList<>();
        List <Integer> list;

        for (Integer i : (list = new ArrayList<>(map.keySet()))) {
            b = map.get(i);
            if (b) {
                nestingIndex = 1;
                int count = 0;
                int currentIndex = 0;
                while (nestingIndex > 0) {
                    count += 1;
                    currentIndex = list.get(list.indexOf(i)+ count);
                    b = map.get(currentIndex);
                    if (b) nestingIndex += 1;
                    else nestingIndex -= 1;
                }
                result.add(s.substring(i, currentIndex + closeTag.length()) );
            }
        }
        result.forEach(System.out::println);
    }
}
