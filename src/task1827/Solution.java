package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

//        String fileName = "E:\\9.txt";

//        FileInputStream fis = new FileInputStream(fileName);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fis));


        if (args.length == 0) {

        } else if (args[0].equals("-c")) {
            add(args, fileName);
        }

    }

    public static void add(String[] args, String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        FileOutputStream fos = new FileOutputStream(fileName, true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        String line = "";

        int max = 0;
        String idStr;
        String productName;
        String price;
        String quantity;
//        double price;
//        int quantity;

        while ((line = br.readLine()) != null) {
            idStr = line.substring(0, 8);
            int id = Integer.parseInt(idStr.trim());
            if (id > max) max = id;
        }
        int m = max + 1;
        idStr = castToLength(String.valueOf(m), 8);

        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < args.length - 2; i++) {
            sb.append(args[i]).append(" ");
        }
        productName = castToLength(sb.toString().trim(), 30);

        price = castToLength(args[args.length - 2], 8);
        quantity = castToLength(args[args.length - 1], 4);

        String data = idStr + productName + price + quantity;
        bw.newLine();
        bw.write(data);

        fis.close();
        br.close();
        bw.flush();
        fos.close();
        bw.close();
    }

    /*
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
1       Трамвай Т-3 новый             15555.004

     */

    private static String castToLength(String str, int l) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        if (length < l) {
            while (sb.length() < l) sb.append(" ");
            return sb.toString();
        } else if (length == l) {
            return str;
        } else {
            return str.substring(0, l);
        }
    }
}
