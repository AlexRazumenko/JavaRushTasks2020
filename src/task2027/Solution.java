package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'}
        };
        List<Word> list = detectAllWords(crossword, "one");
//        f



//
//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
//        List<Word> list = detectAllWords(crossword, "home", "same");
        list.forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new ArrayList<>();
        List<Word> resultList = new ArrayList<>();
        for (String currentWord : words) {
            allWords.addAll(findPossibleWords(crossword, currentWord));
        }

        for (Word currentWord : allWords) {
            String text = currentWord.text;

            char[] chars = text.toCharArray();
            int length = chars.length - 1;
            int x = currentWord.startX;
            int y = currentWord.startY;
//outer:
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {

                    if ((crossword[i][j] == chars[length])) {

                        int lengthX = Math.abs(j - x);
                        int lengthY = Math.abs(i - y);

                        boolean isCongruence = (lengthX == 0 && lengthY == length || lengthX == length && lengthY == 0 || lengthX == length && lengthY == length);
                        if (isCongruence)
                        {
                        int dx = j - x > 0 ? 1 : j - x == 0 ? 0 : -1;
                        int dy = i - y > 0 ? 1 : i - y == 0 ? 0 : -1;

                        boolean found = true;
                        for (int a = x, b = y, c = 0; c < chars.length; a = a + dx, b = b + dy, c++) {
                            try {
                                if (!(chars[c] == crossword[b][a])) {
                                    found = false;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                found = false;
                            }
                        }

                        if (found) {
                            currentWord.setEndPoint(j, i);
                            resultList.add(currentWord);
                            continue;
                        } else break;
//                        break outer;
                    }
                    }
                }
            }
        }
        return resultList;
    }


    private static List<Word> findPossibleWords(int[][] crossword, String wordStr) {
        List <Word> allWords = new ArrayList<>();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                if (crossword[i][j] == (int) wordStr.charAt(0)) {
                    Word word = new Word(wordStr);
                    word.setStartPoint(j, i);
                    allWords.add(word);
                }
            }
        }
        return allWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }

}
