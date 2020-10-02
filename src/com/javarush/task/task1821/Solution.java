package com.javarush.task.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);

        int[] chars = new int[256];

        int currentAsciiCode;
        while ((currentAsciiCode = br.read()) > 0) {
            chars[currentAsciiCode] ++;
        }

        br.close();
        fr.close();

        for (int i = 0; i < 256; i++) {
            if (chars[i] > 0) System.out.println((char) i + " " + chars[i]);
        }
    }
}
