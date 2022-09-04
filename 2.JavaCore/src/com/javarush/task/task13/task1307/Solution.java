package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
1. Класс StringObject должен реализовывать интерфейс SimpleObject.
2. Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
3. В классе StringObject реализуй метод getInstance интерфейса SimpleObject.
4. Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> //допишите здесь ваш код
    {
        public SimpleObject<String> getInstance() {
            return null;
        }
    }
}