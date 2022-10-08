package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.

Инициализируй countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada

1. +Класс Solution должен содержать public static поле countries типа Map<String, String>.
2. +В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
3. +Класс Solution должен содержать интерфейс RowItem.
4. +Класс Solution должен содержать интерфейс Contact.
5. +Класс Solution должен содержать интерфейс Customer.
6. +Класс DataAdapter должен реализовывать интерфейс RowItem.
7. +Класс DataAdapter должен содержать два приватных поля: customer типа Customer и contact Contact.
8. +Класс DataAdapter должен содержать конструктор с параметрами (Customer customer, Contact contact), который
   инициализирует поля contact и customer.
9. В классе DataAdapter реализуй методы интерфейса RowItem используя подсказки в виде комментариев в интерфейсах.
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-4567";
            }
        };

        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            //For example: UA
            String code = "RU";
            String name = customer.getCountryName();
            for(Map.Entry<String, String> country: countries.entrySet())
                if (country.getValue().equals(name)) {
                    code = country.getKey();
                    break;
                }
            return code;
        }

        @Override
        public String getCompany() {
            //For example: JavaRush Ltd.
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] params = contact.getName().split(", ");
            if (params != null && params.length >= 2)
                return params[1];
            else
                return "Unknown";
        }

        @Override
        public String getContactLastName() {
            String[] params = contact.getName().split(", ");
            if (params != null && params.length >= 1)
                return params[0];
            else
                return "Unknown";
        }

        @Override
        public String getDialString() {
            String phone = contact.getPhoneNumber().replaceAll("[^0-9]", "");
            return "callto://+" + phone;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}