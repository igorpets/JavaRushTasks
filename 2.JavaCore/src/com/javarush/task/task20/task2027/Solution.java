package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> result = new ArrayList<>();
        for (String word : words) {
            char first = word.charAt(0);
            char second = word.charAt(1);
            int len_y = crossword.length;
            int len_x = crossword[0].length;
            int delta_x;
            int delta_y;
            boolean go = true;
            for (int y = 0; go && (y < len_y); y++)
                for (int x = 0; go && (x < len_x); x++) {
                    if (crossword[y][x] == first) {
                        for (int ny = Math.max(0, y - 1); go && (ny < Math.max(len_y, y + 1)); ny++)
                            for (int nx = Math.max(0, x - 1); go && (nx < Math.max(len_x, y + 1)); nx++) {
                                if (crossword[ny][nx] == second) {
                                    System.out.println(x + " " + y + " " + nx + " " + ny);
                                    delta_x = nx - x;
                                    delta_y = ny - y;
                                    for (int next_index = 2; next_index < word.length(); next_index++) {
                                        if (crossword[y + delta_y * next_index][x + delta_x * next_index] != word.charAt(next_index)) {
                                            Word res_word = new Word(word);
                                            res_word.setStartPoint(x, y);
                                            res_word.setEndPoint(x + delta_x * (word.length() - 1), y + delta_y * (word.length() - 1));
                                            result.add(res_word);
                                            break;
                                        }
                                    }
                                }
                            }
                    }
                }
        }
        return null;
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
