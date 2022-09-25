package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
1. +Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
2. +Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat sf_in = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        SimpleDateFormat sf_out = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex;
        boolean result;
        int index;
        int new_count = 0;
        switch (args[0]) {
            case "-c":
                result = false;
                while (new_count * 3 + 1 < args.length - 3) {
                    try {
                        sex = args[new_count * 3 + 2];
                        if (sex.equals("м"))
                            result = allPeople.add(Person.createMale(args[1], sf_in.parse(args[3])));
                        else
                            result = allPeople.add(Person.createFemale(args[1], sf_in.parse(args[3])));
                    } catch (Exception e) {
                    }
                }
                if (result)
                    System.out.println(allPeople.size() - 1);
                else
                    System.out.println(-1);
                break;
            case "-r":
                // Миронов м 15-Apr-1990
                Person person = null;
                try {
                    index = Integer.parseInt(args[1]);
                    if (index < allPeople.size())
                        person = allPeople.get(index);
                } catch (Exception e) {
                }
                if (person != null) {
                    if (person.getSex() == Sex.MALE) sex = "м";
                    else sex = "ж";
                    System.out.println(person.getName() + " " + sex + " " + sf_out.format(person.getBirthDate()));
                }
                break;
            case "-u":
                // -c 0 Алексеев м 23/11/1977
                try {
                    index = Integer.parseInt(args[1]);
                    String new_name = args[2];
                    sex = args[3];
                    Date new_bd = sf_in.parse(args[4]);
                    if (index < allPeople.size()) {
                        person = allPeople.get(index);
                        if (person != null) {
                            person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                            person.setName(new_name);
                            person.setBirthDate(new_bd);
                        }
                    }
                } catch (Exception e) {
                }
                break;
            case "-d":
                try {
                    index = Integer.parseInt(args[1]);
                    if (index < allPeople.size()) {
                        person = allPeople.get(index);
                        if (person != null) {
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDate(null);
                        }
                    }
                } catch (Exception e) {
                }
                break;
        }
        /* for (Person p : allPeople) {
            if (p.getName() != null)
                System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м" : "ж") +
                        " " + sf_out.format(p.getBirthDate()));
        }*/
    }
}
