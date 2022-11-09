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
    public static boolean checkTelNumber2(String telNumber) {
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
        String[] strs_false = {"+38(050(1234567", "+38(050)123(456)7"};
        System.out.println("\nВсё, что ниже, должно быть FALSE");
        for (int i = 0; i < strs_false.length; i++)
            System.out.println(strs_false[i] + " = " + checkTelNumber2(strs_false[i]));

        String[] strs_true = {"+38(050)1234567", "+380501234567", "+(380)501234567", "+3(805)01234567",
                "+38(050)1234567", "+380(501)234567",
                "+3805(012)34567", "+38050(123)4567", "+380501(234)567", "+3805012(345)67", "+38050123(456)7"};

        System.out.println("\nВсё, что ниже, должно быть TRUE");
        for (int i = 0; i < strs_true.length; i++) {
            System.out.println(strs_true[i] + " = " + checkTelNumber(strs_true[i]));
        }
    }
    public static boolean checkTelNumber(String telNumber) {
        boolean result = false;

        if (isNumberNotNull(telNumber) && isContainOnlyNumbersPlusAndBrackets(telNumber) && isEndedWithNumber(telNumber)) {
            if (isStartedWithPlus(telNumber) && isContainTwelveNumbers(telNumber)) {
                if (isContainBrackets(telNumber)) {
                    if (isContainOnlyThreeNumbers(telNumber)) {
                        result = true;
                    }
                } else {
                    result = true;
                }
            } else if ((isStartedWithNumber(telNumber) || isStartedWithOpeningBracket(telNumber)) && isContainTenNumbers(telNumber)) {
                if (isContainBrackets(telNumber) && isContainOnlyThreeNumbers(telNumber)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public static boolean isContainBrackets(String number) {
        int countOfStartBracket = 0;
        int countOfEndBracket = 0;

        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                countOfStartBracket++;
            } else if (chars[i] == ')') {
                countOfEndBracket++;
            }
        }

        return (countOfStartBracket == 1 && countOfEndBracket == 1);
    }

    public static boolean isContainOnlyThreeNumbers(String number) {
        boolean result = false;
        char[] chars = number.toCharArray();

        int firstBracketIndex = 0;
        int secondBracketIndex = 0;

        for (char ch : chars) {
            if (ch == '(') {
                firstBracketIndex = number.indexOf(ch);
            } else if (ch == ')') {
                secondBracketIndex = number.lastIndexOf(ch);
            }
        }

        String code;
        if (secondBracketIndex > firstBracketIndex) {
            code = number.substring(firstBracketIndex + 1, secondBracketIndex);
            result = (code.length() == 3);
        }

        return result;
    }

    public static boolean isStartedWithPlus(String number) {
        String firstSymbol = number.substring(0, 1);
        return firstSymbol.equals("+");
    }

    public static boolean isStartedWithNumber(String number) {
        boolean result;
        String firstSymbol = number.substring(0, 1);
        try {
            Integer.parseInt(firstSymbol);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static boolean isStartedWithOpeningBracket(String number) {
        String firstSymbol = number.substring(0, 1);
        return firstSymbol.equals("(");
    }

    public static boolean isContainOnlyNumbersPlusAndBrackets(String number) {
        String replacedTelNumber = number.replaceAll("[^0-9()+]", "");
        return number.equals(replacedTelNumber);
    }

    public static boolean isContainTwelveNumbers(String number) {
        String replacedTelNumber = number.replaceAll("[^0-9]", "");
        return replacedTelNumber.length() == 12;
    }

    public static boolean isContainTenNumbers(String number) {
        String replacedTelNumber = number.replaceAll("[^0-9]", "");
        return replacedTelNumber.length() == 10;
    }

    public static boolean isNumberNotNull(String number) {
        return number != null;
    }

    public static boolean isEndedWithNumber(String number) {
        boolean result;
        String lastSymbol = number.substring(number.length() - 1);

        try {
            Integer.parseInt(lastSymbol);
            result = true;
        } catch (Exception e) {
            result = false;

        }

        return result;
    }
}
