package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        /*int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same").forEach(System.out::println);
        */
        int[][] crossword = new int[][]{
                {'k', 'l', 'o', 'o', 'l'},
                {'l', 'o', 'k', 'o', 'l'},
                {'k', 'o', 'o', 'l', 'k'},
        };
        detectAllWords(crossword, "kol", "k").forEach(System.out::println);
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
            char second = 0;
            int word_len = word.length();
            if (word_len > 1)
                second = word.charAt(1);
            int len_y = crossword.length;
            int len_x = crossword[0].length;
            int delta_x;
            int delta_y;
            for (int y = 0; (y < len_y); y++)
                for (int x = 0; (x < len_x); x++) {
                    if (crossword[y][x] == first) {
                        if (word.length() == 1) {
                            result.add(add_word(word, x, y, x, y));
                        } else {
                            for (int ny = Math.max(0, y - 1); (ny < Math.max(len_y, y + 1)); ny++) {
                                for (int nx = Math.max(0, x - 1); (nx < Math.max(len_x, x + 1)); nx++) {
                                    if (ny==y && nx == x) continue;
                                    if (crossword[ny][nx] == second) {
                                        if (word.length() == 2) {
                                            result.add(add_word(word, x, y, nx, ny));
                                        } else {
                                            delta_y = ny - y;
                                            delta_x = nx - x;
                                            boolean find = true;
                                            for (int next_index = 2; next_index < word.length(); next_index++) {
                                                int y2 = y + delta_y * next_index;
                                                int x2 = x + delta_x * next_index;
                                                if (y2 < 0 || y2 >= crossword.length ||
                                                        x2 < 0 || x2 >= crossword[y].length ||
                                                        crossword[y2][x2] != word.charAt(next_index)) {
                                                    find = false;
                                                    break;
                                                }
                                            }
                                            if (find) {
                                                result.add(add_word(word, x, y, x + delta_x * (word.length() - 1),
                                                        y + delta_y * (word.length() - 1)));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
        return result;
    }

    private static Word add_word(String word, int x1, int y1, int x2, int y2) {
        Word res_word = new Word(word);
        res_word.setStartPoint(x1, y1);
        res_word.setEndPoint(x2, y2);
        return res_word;
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
