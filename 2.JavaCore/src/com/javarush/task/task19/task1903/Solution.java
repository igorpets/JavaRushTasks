package com.javarush.task.task19.task1903;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
Давай представим ситуацию, что с одной стороны у нас есть некая база данных, в которой хранятся данные.
База данных имеет стандартный набор команд (методов) для предоставления данных, они описаны в интерфейсе IncomeData.
Примеры представления данных приведены в комментариях около каждого метода. С другой стороны есть пользователи,
которые хотят получать данные из этой базы, но в каком-то другом (конкретном) формате. Запросы от пользователей
представлены методами в интерфейсах Customer и Contact. Там же (в комментариях около каждого метода) есть примеры
представления информации в том виде, в котором пользователи хотят ее получать из базы данных.

Твоя задача: написать логику класса адаптера IncomeDataAdapter, который будет по запросам методов из интерфейсов
Customer и Contact, обращаться в базу (методы интерфейса IncomeData), получать данные, обрабатывать их, при
необходимости изменять представление, и возвращать в виде результата.

Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada

При необходимости дополни начало телефонного номера (без кода страны) нулями до 10 цифр (смотри примеры в
комментарии к соответствующему методу). Обрати внимание на формат вывода телефона, фамилии и имени человека
(смотри примеры в комментарии к соответствующему методу).

1. +Класс Solution должен содержать public static поле countries типа Map<String, String>.
2. +В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. +Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
4. Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
5. Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
6. В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде
   комментариев в интерфейсах.
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 71112233;
            }
        });

        System.out.println(incomeDataAdapter.getCompanyName());
        System.out.println(incomeDataAdapter.getCountryName());
        System.out.println(incomeDataAdapter.getName());
        System.out.println(incomeDataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            //For example: JavaRush Ltd.
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            //For example: Ukraine
            return countries.getOrDefault(data.getCountryCode(), countries.get("RU"));
        }

        @Override
        public String getName() {
            //For example: Ivanov, Ivan
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
            String zero = "0000000000";
            String phone = String.valueOf(data.getPhoneNumber());
            int len = phone.length();
            if (len < 10)
                phone = zero.substring(0, 10 - len) + phone;
            try {
                MaskFormatter format = new MaskFormatter("(###)###-##-##");
                format.setValueContainsLiteralCharacters(false);
                phone = format.valueToString(phone);
            } catch (ParseException e) {
            }
            return "+" + data.getCountryPhoneCode() + phone;
            //return "+" + data.getCountryPhoneCode() + "(" + phone.substring(0, 3) + ")" + phone.substring(3);
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber() throws ParseException;        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}
