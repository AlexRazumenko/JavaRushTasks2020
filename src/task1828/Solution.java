package com.javarush.task.task18.task1828;

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

//        String fileName = "E:\\11.txt";

        if (args[0].equals("-u")) update(args, fileName);
        if (args[0].equals("-d")) delete(args[1], fileName);

    }

    /*
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
00011   Tram T3                       99999.0 123
     */

    private static void update(String[] args, String fileName) throws IOException {

        fis = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader (fis));
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String idStr = line.substring(0,8);
            int id = Integer.parseInt(idStr.trim());
            if (id != Integer.parseInt(args[1])) {
                sb.append(line).append("\n");
                continue;
            }
            System.out.println(line);
            String[] words = line.split(" ");
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
