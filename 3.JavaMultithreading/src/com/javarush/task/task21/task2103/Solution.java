package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
+1. Метод calculate должен быть статическим.
+2. Метод calculate должен возвращать значение типа boolean.
+3. Метод calculate должен принимать четыре параметра типа boolean.
4. Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).

return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
return c && ((a && b && !d) || (!a) || (!b) || (d));
true
true
false
false
false
true
true
false
false
true
true
false
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {
        System.out.println(calculate(true, true, true, true));
        System.out.println(calculate(true, true, true, false));
        System.out.println(calculate(true, true, false, false));
        System.out.println(calculate(true, false, false, false));
        System.out.println(calculate(true, false, false, true));
        System.out.println(calculate(true, false, true, false));
        System.out.println(calculate(true, false, true, true));
        System.out.println(calculate(false, false, false, false));
        System.out.println(calculate(false, false, false, true));
        System.out.println(calculate(false, false, true, true));
        System.out.println(calculate(false, true, true, true));
        System.out.println(calculate(false, true, false, true));
    }
}
