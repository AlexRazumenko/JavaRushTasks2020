package com.javarush.task.task31.task3105;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        List<ZipEntry> entryList = new ArrayList<>();

        Path filePath = Paths.get(args[0]);
        Path zipArchivePath = Paths.get(args[1]);

Path tempDir = Files.createTempDirectory(zipArchivePath.getParent(), "tmp-");

        ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipArchivePath));
        while (zis.available() > 0) {
            ZipEntry entry = zis.getNextEntry();
            entryList.add(entry);
        }

//        for (ZipEntry entry : entryList)

        Path newDir = Files.createDirectory(Paths.get(tempDir.toString() + "new"));
        Path newFile = Files.copy(filePath, Paths.get(newDir.toString() + filePath.getFileName()));

//        ZipEntry newEntry = new ZipEntry(newFile.toString());
//        entryList.add(newDir)
//        entryList.add(newEntry);

        ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipArchivePath));
        Files.copy(newDir, zos);
        Files.copy(filePath, zos);

        for (ZipEntry entry : entryList) {
            zos.putNextEntry(entry);
            zos.closeEntry();
        }

        zis.close();
        zos.close();

    }
}
