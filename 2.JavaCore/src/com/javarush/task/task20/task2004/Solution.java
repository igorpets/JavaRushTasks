package com.javarush.task.task20.task2004;

import java.io.*;
import java.util.Date;
import java.util.Properties;

/* 
Читаем и пишем в файл статики
Реализуй логику записи в файл и чтения из файла для класса ClassWithStatic.
Метод load должен инициализировать объект включая статические поля данными из файла.
Метод main не участвует в тестировании.

1. Должна быть реализована возможность сохранения/загрузки объектов типа Solution.ClassWithStatic
   с помощью методов save/load.
2. Класс Solution не должен поддерживать интерфейс Serializable.
3. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Serializable.
4. Класс Solution.ClassWithStatic должен быть публичным.
5. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {


            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;

            File yourFile = File.createTempFile("prop", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            classWithStatic.save(outputStream);
            outputStream.flush();
            outputStream.close();


            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            InputStream inputStream = new FileInputStream(yourFile);
            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            if (loadedObject.equals(classWithStatic) && ClassWithStatic.staticString.equals("This is a static test string"))
                System.out.println("OK");
            else
                System.out.println("ERROR");
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties prop = new Properties();
            prop.put("staticString", staticString);
            prop.put("var_i", String.valueOf(i));
            prop.put("var_j", String.valueOf(j));
            prop.store(outputStream, new Date().toString());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties prop = new Properties();
            prop.load(inputStream);
            staticString = prop.getProperty("staticString");
            i = Integer.parseInt(prop.getProperty("var_i"));
            j = Integer.parseInt(prop.getProperty("var_j"));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
