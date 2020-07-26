package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        Map<String, Double> allPeople = new TreeMap<>();
        Set<Integer> max = new TreeSet<>();

        String fileName = args[0];
        FileReader fr = new FileReader(fileName);
        BufferedReader br1 = new BufferedReader(fr);

        String line;
        while ((line = br1.readLine()) != null) {
            String[] dataFromLine = line.split(" ");
            String key = dataFromLine[0];
            Double value = Double.parseDouble(dataFromLine[1]);

            if (!allPeople.containsKey(key)) allPeople.put(key, value);
            else allPeople.put(key, allPeople.get(key) + value);
        }

        Double maxVal = Collections.max(allPeople.values());

        for (Map.Entry<String, Double> entry : allPeople.entrySet()) {
            if (entry.getValue().equals(maxVal))
            System.out.println(entry.getKey());
        }

        fr.close();
        br1.close();






    }
}
