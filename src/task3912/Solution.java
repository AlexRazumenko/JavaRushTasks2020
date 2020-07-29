package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

        int[][] rect = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 0}
        };

        System.out.println(maxSquare(rect));
    }

    public static int maxSquare(int[][] matrix) {

        int side = 0;
        if (matrix.length == 1 || matrix[0].length == 1) return 1;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i][j-1],matrix[i-1][j]))+1;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] > side) side = matrix[i][j];
            }
        }
    return side*side;
    }
}
