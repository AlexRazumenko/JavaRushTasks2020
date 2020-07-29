package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.util.List;

/* 
Своя реализация
*/
public class Solution {

    public static byte[] readBytes(String fileName) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get(fileName);
        return java.nio.file.Files.readAllBytes(path);
    }

    public static List<String> readLines(String fileName) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get(fileName);
//        java.io.File file = new java.io.File(fileName);
        return java.nio.file.Files.readAllLines(path);
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get(fileName);
        java.nio.file.Files.write(path, bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        java.nio.file.Path path1 = java.nio.file.Paths.get(resourceFileName);
        java.nio.file.Path path2 = java.nio.file.Paths.get(destinationFileName);
        java.nio.file.Files.copy(path1, path2);
    }
}
