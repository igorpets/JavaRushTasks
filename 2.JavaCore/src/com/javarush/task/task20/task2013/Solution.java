package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/* 
Externalizable Person
Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.

1. В классе Solution.Person должен быть создан публичный конструктор без параметров.
2. В классе Solution.Person должен быть создан конструктор с тремя параметрами (String firstName, String lastName, int age).
3. Класс Solution.Person должен поддерживать интерфейс Externalizable.
4. Методы readExternal и writeExternal должны позволять корректно сериализовывать и десериализовывать объекты типа Person.
*/

public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) {
        /*try {
            File your_file_name = File.createTempFile("your_file_name", null);
            FileOutputStream fileOutputStream = new FileOutputStream(your_file_name);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            Person pers = new Person("Иван", "Костенецкий", 34);
            pers.writeExternal(objectOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

            Person pers2 = new Person();
            FileInputStream fileInputStream = new FileInputStream(your_file_name);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            pers2.readExternal(objectInputStream);
            // Проверка!
            System.out.println(pers.equals(pers2));
            objectInputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }*/

    }
}
