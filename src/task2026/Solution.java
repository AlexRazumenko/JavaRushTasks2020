package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < a[0].length; x++) {
                byte current = a[y][x];
                boolean cond1, cond2;
                cond1 = cond2 = false;

                if (current == 1) {
                    if ((x + 1 >= a[0].length) || (a[y][x + 1] == 0)) cond1 = true;
                    if ((y + 1 >= a.length) || (a[y + 1][x] == 0)) cond2 = true;
                    if (cond1 && cond2) count++;
                }

            }
        }
        return count;
    }
}
