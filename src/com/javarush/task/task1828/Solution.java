package com.javarush.task.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    private static FileInputStream fis;
    private static BufferedReader br;
    private static FileOutputStream fos;
    private static BufferedWriter bw;

    private static String line;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        if (args[0].equals("-u")) update(args, fileName);
        if (args[0].equals("-d")) delete(args[1], fileName);

    }


    private static void update(String[] args, String fileName) throws IOException {

        fis = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();

        //reading all lines from file
        while ((line = br.readLine()) != null) {
            System.out.println(line);


            String idStr = line.substring(0,8); //symbols from 0 to 7 marks id
            int id = Integer.parseInt(idStr.trim());

            //if current string does not represent required product
            if (id != Integer.parseInt(args[1])) {
                sb.append(line).append("\n");
                continue;
            }

            //when required line is found
            System.out.println(line);
            String productName = castToLength(args[2], 30); 
            String price = castToLength(args[3], 8);
            System.out.println(line);
            String quantity = castToLength(args[4], 4);
            line = idStr + productName + price + quantity;
            System.out.println(line);
            sb.append(line).append("\n");
        }

        fos = new FileOutputStream(fileName);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        fis.close();
        fos.close();
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void delete(String id, String fileName) throws IOException {
        fis = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader (fis));

        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            String idStr = line.substring(0,8);
            if (idStr.trim().equals(id)) continue;
            sb.append(line).append("\n");
        }
        fos = new FileOutputStream(fileName);
        bw = new BufferedWriter(new OutputStreamWriter(fos));

        fis.close();
        fos.close();
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static String castToLength(String str, int size) {
        int length = str.length();
        if (length < size) {
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() < size) sb.append(" ");
            return sb.toString();
        } else if (length == size) {
            return str;
        } else {
            return str.substring(0, size);
        }
    }
}
