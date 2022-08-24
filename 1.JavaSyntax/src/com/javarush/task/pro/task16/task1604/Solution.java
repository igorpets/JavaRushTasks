package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1999, Calendar.JANUARY, 23);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код

        String result = "";
        switch (calendar.get(Calendar.DAY_OF_WEEK) - 1) {
            case 0:
                result = "воскресенье";
                break;
            case 1:
                result = "понедельник";
                break;
            case 2:
                result = "вторник";
                break;
            case 3:
                result = "среда";
                break;
            case 4:
                result = "четверг";
                break;
            case 5:
                result = "пятница";
                break;
            case 6:
                result = "суббота";
                break;
        }
        return result;
    }
}
