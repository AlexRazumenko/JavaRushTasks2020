package com.javarush.task.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        System.out.println("Input data file name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        if (args[0].equals("-c")) {
            add(args, fileName);
        }
    }

    public static void add(String[] args, String fileName) throws IOException {

        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        FileOutputStream fos = new FileOutputStream(fileName, true);
        String line = "";

        // declaring parameters
        int max = 0;
        String idStr;
        String productName;
        String price;
        String quantity;

        // finding maximum id in first 8 bytes of every line
        while ((line = br.readLine()) != null) {
            idStr = line.substring(0, 8);
            int id = Integer.parseInt(idStr.trim());
            if (id > max) max = id;
        }
        // next id generation by incrementing max found id
        int m = max + 1;
        // casting string representation of id to required length(8 symbols)
        idStr = castToLength(String.valueOf(m), 8);

        // productName is all of the arguments except one first and two last
        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i < args.length - 2; i++) {
            sb.append(args[i]).append(" ");
        }

        // casting string representation of productName, price, quantity to required length(30,8,4 symbols)
        productName = castToLength(sb.toString().trim(), 30);
        price = castToLength(args[args.length - 2], 8);
        quantity = castToLength(args[args.length - 1], 4);

        String dataToWrite = idStr + productName + price + quantity;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.newLine();
        bw.write(dataToWrite);

        fis.close();
        br.close();
        bw.flush();
        fos.close();
        bw.close();
    }

    // casting incoming string to required length by trimming or adding whitespaces
    private static String castToLength(String str, int requiredLength) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        if (length < requiredLength) {
            while (sb.length() < requiredLength) sb.append(" ");
            return sb.toString();
        } else if (length == requiredLength) {
            return str;
        } else {
            return str.substring(0, requiredLength);
        }
    }
}
