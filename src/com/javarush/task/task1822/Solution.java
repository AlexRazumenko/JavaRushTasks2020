package com.javarush.task.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        int id = Integer.parseInt(args[0]);
        String line;

        while ((line = br.readLine()) != null) {
            String indexStr = line.substring(0, line.trim().indexOf(" "));
            int index = Integer.parseInt(indexStr);
            if (index == id) System.out.println(line);
        }

        fis.close();
        br.close();

    }

//    public void print (String line) {
//
//    }
}
