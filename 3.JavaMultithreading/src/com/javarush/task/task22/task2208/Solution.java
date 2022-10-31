package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'

1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<>();
        test.put("name", "Иванов");
        test.put("country", null);
        test.put("age", "34");

        System.out.println(getQuery(test));
    }

    public static String getQuery(Map<String, String> params) {
        if (params == null) return "";
        StringBuilder result = new StringBuilder("");
        for (String param: params.keySet()) {
            String val = params.get(param);
            if (val != null) {
                if (result.length() > 0) result.append(" and ");
                result.append(param + " = '" + val + "'");
            }
        }
        return result.toString();
    }
}
