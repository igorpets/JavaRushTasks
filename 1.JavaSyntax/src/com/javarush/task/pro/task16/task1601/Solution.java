package com.javarush.task.pro.task16.task1601;

import java.util.Date;


/* 
Лишь бы не в понедельник :)
*/

public class Solution {
    static Date birthDate = new Date(1999-1900, 2, 12);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String result = "";
        //System.out.println("date = " + date);
        //System.out.println("simple = "+new SimpleDateFormat("EEEE",Locale.forLanguageTag("ru")).format(date));
        int day = date.getDay();
        switch (day) {
            case 0:
                result = "воскресенье";break;
            case 1:
                result = "понедельник";break;
            case 2:
                result = "вторник";break;
            case 3:
                result = "среда";break;
            case 4:
                result = "четверг";break;
            case 5:
                result = "пятница";break;
            case 6:
                result = "суббота";break;
        }
        return result;
    }
}
        /* System.out.println(date+" day= "+date.getDay());
        //напишите тут ваш код
        int day = date.getDay();
        DayOfWeek dayOfWeek = DayOfWeek.of(day+1);
        Locale localeRu = new Locale("ru", "RU");
        int day2 = Calendar.(1999, Calendar.MARCH, 12).get(Calendar.DAY_OF_MONTH)
        System.out.println();

        return dayOfWeek.getDisplayName(TextStyle.FULL,localeRu);
        */
