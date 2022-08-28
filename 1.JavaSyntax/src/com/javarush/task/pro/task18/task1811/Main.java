package com.javarush.task.pro.task18.task1811;

public class Main {

    public static void main(String[] args) {

        MonitoringSystem generalModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг общих показателей стартовал!");
            }
        };


        MonitoringSystem errorModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг отслеживания ошибок стартовал!");
            }
        };

        MonitoringSystem securityModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг безопасности стартовал!");
            }
        };
        generalModule.startMonitoring();
        errorModule.startMonitoring();
        securityModule.startMonitoring();
        int y = 0;
        eee:
        for (int i = 1; i < 4 && y < 100; i++) {
            System.out.println("\ntest1 "+i + " " + y);
            y++;
            //if (i == 4) break eee;
            eee2:
            {
                if (i == 2) break eee2;
                System.out.println("test2 " + i);
                System.out.println("test3 " + i);
            }
            System.out.println("test4 " + i);
        }
    }
}