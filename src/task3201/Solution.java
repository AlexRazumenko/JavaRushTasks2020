package task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

//        File file = new File(fileName);

        RandomAccessFile ra = new RandomAccessFile(fileName, "rw");
        if (ra.length() < number) ra.seek(ra.length());
        else
            ra.seek(number);
        ra.write(text.getBytes());

    }
}
