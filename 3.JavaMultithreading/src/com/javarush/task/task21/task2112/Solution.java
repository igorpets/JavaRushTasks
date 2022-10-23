package com.javarush.task.task21.task2112;

/*
3. В методе main класса Solution должны быть вызваны методы usefulOperation и unsupportedOperation
   у объекта класса FakeConnection.
4. Вывод на экран должен соответствовать условию задачи.
5. Метод close класса FakeConnection не должен быть вызван явно.
 */
public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
        }
    }
}
