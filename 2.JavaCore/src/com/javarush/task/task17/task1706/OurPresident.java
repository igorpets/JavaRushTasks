package com.javarush.task.task17.task1706;

/*
1. +Класс OurPresident должен содержать приватное статическое поле OurPresident president.
2. +Класс OurPresident должен содержать публичный статический метод OurPresident getOurPresident().
3. +Класс OurPresident должен содержать приватный конструктор.
4. +Класс OurPresident должен содержать статический блок.
5. +Внутри статического блока класса OurPresident должен быть синхронизированный блок.
6. +Внутри синхронизированного блока должно быть проинициализировано поле president.
*/
public class OurPresident {
    private static OurPresident president;
    static  {
        synchronized (OurPresident.class){
            if ( president == null)
                president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
