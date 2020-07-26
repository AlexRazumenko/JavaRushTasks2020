package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(fileName2));

        String line;
        StringBuilder sb = new StringBuilder("");
        while ((line = br1.readLine()) != null) {
            sb.append(line.replaceAll("\\p{Punct}", ""));
        }

        bw2.write(sb.toString());

        br1.close();
        bw2.close();
    }
}
