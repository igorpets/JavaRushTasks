package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона

Примеры:
+380501234567 - true
+38(050)1234567 - true
(050)1234567 - true
0(501)234567 - true
+38)050(1234567 - false
+38(050)123-45-67 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false

1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() == 0) return false;
        //Критерии валидности:
        int count_dig = 0;
        for (char chr : telNumber.toCharArray()) {
            if (Character.isDigit(chr)) count_dig++;
            //5) номер может содержать только цифры, '+', '(' и ')'
            if (chr != '+' && chr != '(' && chr != ')' && !Character.isDigit(chr)) return false;
        }
        //1) если номер начинается с '+', то он содержит 12 цифр
        if (telNumber.indexOf('+') >= 0) {
            if (count_dig != 12) return false;
        }
        //2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        char first = telNumber.charAt(0);
        if (Character.isDigit(first) || first == '(') {
            if (count_dig != 10) return false;
        }
        //3) может содержать 1 пару скобок '(' и ')'
        int index1 = telNumber.indexOf("(");
        if (index1 >=0){
            if (telNumber.indexOf("(",index1+1)>=0) return false;
            int index2 = telNumber.indexOf(")");
            if (index2 < index1) return false;
            int index3 = telNumber.indexOf(")", index2+1);
            if (index3 >=0) return false;
            //4) скобки (если они есть) внутри содержат четко 3 цифры
            if (index2 - index1 != 4) return false;
        }
        //6) номер заканчивается на цифру
        if (!Character.isDigit(telNumber.charAt(telNumber.length()-1)))
            return false;
        return true;
    }

    public static void main(String[] args) {
        String str = "+380501234567";
        if (checkTelNumber(str) != true)
            System.out.println("Error: " + str);
        str = "+38(050)1234567";
        if (checkTelNumber(str) != true)
            System.out.println("Error: " + str);

        String[] strs = {"+(380)501234567", "+3(805)01234567", "+38(050)1234567", "+380(501)234567",
                "+3805(012)34567", "+38050(123)4567", "+380501(234)567", "+3805012(345)67", "+38050123(456)7"};

        for (int i = 0; i < strs.length; i++) {
            if (i == 0) System.out.println("\nВсё, что ниже, должно быть true");
            System.out.println(strs[i] + " = " + checkTelNumber(strs[i]));
        }
    }
}
