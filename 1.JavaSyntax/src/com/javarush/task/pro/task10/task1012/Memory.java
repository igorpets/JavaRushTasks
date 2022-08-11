package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        //напишите тут ваш код
        if (array == null) return;
        int null_ptr = -1;
        for(int i=0; i<array.length ; i++) {
            if (array[i] == null) {
                null_ptr = i;
                break;
            }
        }
        if (null_ptr>=0) {
            for (int k = null_ptr + 1; k<array.length; k++) {
                if (array[k] != null) {
                    array[null_ptr] = array[k];
                    array[k] = null;
                    null_ptr = null_ptr + 1;
                }
            }
        }
    }
}
