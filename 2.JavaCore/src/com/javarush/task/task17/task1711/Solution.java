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
3. +При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. +При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. +При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
-d 0 -r 1 -d 0 -u 0 Алексеев м 23/11/1977 -c Миронов м 15/04/1990
-c Миронов м 15/04/1990 Алексеева ж 23/02/1990 Батуева ж 30/01/2001
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createMale("Козлов Павел", new Date()));  //сегодня родился    id=1
        //allPeople.add(Person.createFemale("Габьева Василиса", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat sf_in = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        SimpleDateFormat sf_out = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sex;
        boolean result;
        int index;
        int new_count = 0;
        Person person;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    result = false;
                    while (new_count * 3 + 1 <= args.length - 3) {
                        index = new_count * 3 + 1;
                        //System.out.println(index + " " + (args.length - 3));
                        try {
                            sex = args[index + 1];
                            if (sex.equals("м"))
                                result = allPeople.add(Person.createMale(args[index], sf_in.parse(args[index + 2])));
                            else
                                result = allPeople.add(Person.createFemale(args[index], sf_in.parse(args[index + 2])));
                        } catch (Exception e) {
                        }
                        if (result) {
                            if (new_count == 0)
                                System.out.print(allPeople.size() - 1);
                            else
                                System.out.print(" " + (allPeople.size() - 1));
                        }
                        new_count++;
                    }
                    if (result)
                        System.out.println();
                }
                break;
            case "-u":
                // -u 0 Алексеев м 23/11/1977 1 Митрофанкина ж 12/12/2001
                synchronized (allPeople) {
                    while (new_count * 4 + 1 <= args.length - 4) {
                        index = new_count * 4 + 1;
                        try {
                            int bd_index = Integer.parseInt(args[index]);
                            String new_name = args[index + 1];
                            sex = args[index + 2];
                            Date new_bd = sf_in.parse(args[index + 3]);
                            if (bd_index < allPeople.size()) {
                                person = allPeople.get(bd_index);
                                if (person != null) {
                                    person.setSex(sex.equals("м") ? Sex.MALE : Sex.FEMALE);
                                    person.setName(new_name);
                                    person.setBirthDate(new_bd);
                                }
                            }
                        } catch (Exception e) {
                        }
                        new_count++;
                    }
                }
                break;
            case "-d":
                // -d 1 2
                synchronized (allPeople) {
                    while (new_count + 1 <= args.length - 1) {
                        index = new_count + 1;
                        try {
                            int bd_index = Integer.parseInt(args[index]);
                            if (bd_index < allPeople.size()) {
                                person = allPeople.get(bd_index);
                                if (person != null) {
                                    person.setName(null);
                                    person.setSex(null);
                                    person.setBirthDate(null);
                                }
                            }
                        } catch (Exception e) {
                        }
                        new_count++;
                    }
                }
                break;
            case "-i":
                // -i 0 1
                synchronized (allPeople) {
                    // Миронов м 15-Apr-1990
                    while (new_count + 1 <= args.length - 1) {
                        index = new_count + 1;
                        person = null;
                        try {
                            int bd_index = Integer.parseInt(args[index]);
                            if (bd_index < allPeople.size())
                                person = allPeople.get(bd_index);
                        } catch (Exception e) {
                        }
                        if (person != null) {
                            if (person.getSex() == Sex.MALE) sex = "м";
                            else sex = "ж";
                            System.out.println(person.getName() + " " + sex + " " + sf_out.format(person.getBirthDate()));
                        }
                        new_count++;
                    }
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
