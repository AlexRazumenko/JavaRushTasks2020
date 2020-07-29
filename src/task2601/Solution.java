package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i=1; i<array.length; i++) {
                if (array[i-1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    isSorted = false;
                }
            }
        }

        int length = array.length;
        int median;
        if (array.length % 2 == 0) median = (array[length/2] + array [length/2-1]) / 2;
        else median = array[length/2];

        isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i=1; i<array.length; i++) {
                if (Math.abs(array[i-1] - median) > Math.abs(array[i] - median)) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    isSorted = false;
                }
            }
        }
        return array;
    }
}
