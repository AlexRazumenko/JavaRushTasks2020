package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Path tempDir = Files.createTempDirectory(downloadDirectory, "tmp");
        Path tempFile = Files.createTempFile("temp-", ".tmp");


        String fileName = urlString.substring(urlString.lastIndexOf('/')+1);
        Path res = downloadDirectory.resolve(Paths.get(fileName));
        Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.move(tempFile,res, StandardCopyOption.REPLACE_EXISTING);

//        Path tempFile = Files.createTempFile(tempDir, "temp-", ".tmp");
//        Files.copy(is, tempFile, StandardCopyOption.REPLACE_EXISTING);
//        String resultPath = downloadDirectory.toString()  + "/" +  urlString.substring(urlString.lastIndexOf('/') + 1);
//        Path res = downloadDirectory.resolve(Paths.get(resultPath));
//        Files.move(tempFile,res, StandardCopyOption.REPLACE_EXISTING);
        return res; // implement this method
    }

}
