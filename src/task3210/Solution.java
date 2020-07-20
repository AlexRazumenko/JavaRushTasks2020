package task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        byte[] buf = new byte[text.length()];

        RandomAccessFile ra = new RandomAccessFile(fileName, "rw");
        ra.seek(number);
        ra.read(buf, 0, text.length());
        String text2 = new String(buf);
        String append;
        if (text.equals(text2)) append = "true";
        else append = "false";

        ra.seek (ra.length());
        ra.write(append.getBytes());
    }
}
