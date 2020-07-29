package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        String str = "no data";
        if (is != null) {
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buf = new byte[bis.available()];
            bis.read(buf);
            if (buf.length > 0)
                str = new String(buf);
        }
        StringWriter sw = new StringWriter();
        sw.write(str);

        return sw;
    }
}