package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот

+1. Метод main должен считывать имя файла с клавиатуры.
+2. В методе main должен быть использован StringBuilder.
+3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString.
    Удалять или изменять эти методы нельзя.
+4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
++5. Список result должен быть заполнен корректными парами согласно условию задачи.
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new FileReader(scan.nextLine()))) {
            String line;
            ArrayList<String> data = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for(String word:words)
                    data.add(word);
            }
            for (int i = 0; i < data.size(); i++) {
                String word = data.get(i);
                if (word == null || word.length() == 0) continue;
                String strb = new StringBuilder(word).reverse().toString();
                data.set(i, null);
                int index = data.indexOf(strb);
                if (index >= 0) {
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = strb;
                    result.add(pair);
                    //System.out.println(word + " " + strb);
                    data.set(index, null);
                }
            }
        } catch (Exception e) {
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){}
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
