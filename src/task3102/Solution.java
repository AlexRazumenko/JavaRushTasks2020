package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> fileQueue = new LinkedList<>();
        File rootFile = new File(root);
        fileQueue.offer(rootFile);
        List<String> result = new ArrayList<>();

        while (fileQueue.size() > 0) {
            File head = fileQueue.poll();
            if (head.isDirectory()) {
                for (File file : head.listFiles()) {
                    fileQueue.offer(file);
                }
            } else {
                result.add(head.getAbsolutePath());
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
