package com.javarush.task.pro.task16.task1621;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Напиши шаблон
*/

public class Solution {

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    static String timeString = "13:30:45 23/02/2019";

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.parse(timeString, dateTimeFormatter);

        System.out.println(dateTime);
        test();
    }
    private static void test(){
        Calendar cl = new GregorianCalendar();
        Date date = new Date();
        LocalDate date2 = LocalDate.now();
        System.out.println(date+" " + date.getMonth()+"  "+date2.getMonthValue()+" " +cl.get(Calendar.MONTH));

    }
}
