package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            this.fileData =
                    new ConcreteFileData(Files.isHidden(file), Files.isExecutable(file), Files.isDirectory(file), Files.isWritable(file));
        } catch (Exception e) {
            this.fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
