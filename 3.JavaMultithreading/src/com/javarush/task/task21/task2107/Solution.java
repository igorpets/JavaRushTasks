package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.

+1. Класс Solution должен поддерживать интерфейс Cloneable.
+2. Класс User должен поддерживать интерфейс Cloneable.
+3. В классе User должен быть корректно реализован метод clone.
+4. В классе Solution должен быть корректно реализован метод clone.
*/

public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    public Solution clone(){
        Solution clon = new Solution();
        for (User user: users.values()){
            clon.users.put(user.name, user.clone());
        }
        return clon;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public User clone(){
            return new User(age, name);
        }
        public int hashCode(){
            return age + name.hashCode();
        }
        public boolean equals(Object obj){
            if (obj == null) return false;
            if (!(obj instanceof User) ) return false;
            User user = (User)obj;
            if (age != user.age) return false;
            if (name == null && user.name != null) return false;
            if (name == user.name) return true;
            return (name.equals(user.name));
        }
    }
}
