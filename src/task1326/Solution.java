package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String str;

        String fileName = b.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader (new InputStreamReader(fis));

        while ((str = br.readLine()) != null) {
            int i = Integer.parseInt(str);
            if ((i % 2 == 0)) list.add(i);
        }

        b.close();
        fis.close();
        br.close();

        int temp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int a = 1; a < list.size(); a++) {

                if (list.get(a) < list.get(a - 1)) {
                    temp = list.get(a);
                    list.set(a, list.get(a - 1));
                    list.set(a - 1, temp);
                    isSorted = false;
                }
            }
        }

        for (Integer i : list) System.out.println(i);
    }
}
