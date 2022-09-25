package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
1. +Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. +Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. +При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. +При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
5. +При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
6. +При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        SimpleDateFormat sf_in = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        SimpleDateFormat sf_out = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex;
        boolean result;
        int index;
        switch (args[0]) {
            case "-c":
                result = false;
                try {
                    sex = args[2];
                    if (sex.equals("м"))
                        result = allPeople.add(Person.createMale(args[1], sf_in.parse(args[3])));
                    else
                        result = allPeople.add(Person.createFemale(args[1], sf_in.parse(args[3])));
                } catch (Exception e) {
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
