package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException, NullPointerException {
        List<File> files = new ArrayList<>();

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File destinationFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFileAbsolutePath, destinationFile);

        Comparator<File> listComparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        walkFiles(path, files);
        files.sort(listComparator);

        FileOutputStream fos = new FileOutputStream(destinationFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        FileWriter fw = new FileWriter(destinationFile);
        BufferedWriter bw = new BufferedWriter(fw);
        StringBuilder sb = new StringBuilder();

        for (File file : files) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            sb.append("\n");

            fr.close();
            br.close();
        }
        bw.write(sb.toString());
        bw.flush();
        fw.close();
        bw.close();
    }

    private static void walkFiles(File directory, List<File> fileList) throws NullPointerException {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) walkFiles(file, fileList);
            else {
                if (file.length() <= 50L) fileList.add(file);
//                if (file.length() <= 50) map.put(file.getName(), file);
            }
        }
    }
}
