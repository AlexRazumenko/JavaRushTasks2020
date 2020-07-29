package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        br.close();

        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));  //E:\\16.txt
        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));  //E:\\17.txt

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        String line;

        while ((line = br1.readLine()) != null) {
            list1.add(line);
        }

        while ((line = br2.readLine()) != null) {
            list2.add(line);
        }

        br1.close();
        br2.close();

        while (list2.size() > 0) {
            if (list1.size() > 0 && list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.remove(0)));
                list2.remove(0);
            } else if (list1.size() > 1 && list2.get(0).equals(list1.get(1))) {
                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
            } else if (list2.size() > 1 && list1.size() > 0 && list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.remove(0)));
            } else if (list1.size() == 1) {
                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
            } else if (list1.size() == 0) {
                lines.add(new LineItem(Type.ADDED, list2.remove(0)));
            }
        }

        if (list1.size() > 0) {
            while (list1.size() > 0) {
                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
            }
        }

//        lines.forEach(lineItem -> {
//            System.out.println(lineItem.type.name() + lineItem.line);
//        });
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
