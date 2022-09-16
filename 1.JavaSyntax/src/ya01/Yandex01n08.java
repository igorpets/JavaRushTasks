package ya01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Yandex01n08 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String[] param = reader.readLine().split(" ");
            TreeSet<Long> timers = Arrays.stream(reader.readLine().split(" ")).mapToLong(a->Long.parseLong(a)).collect(()->new TreeSet<Long>(), TreeSet::add, TreeSet::addAll);

            if (param.length == 3) {
                // Время срабатывания будильников.
                int timerDuration = Integer.parseInt(param[1]);
                // Количество звонков до пробуждения
                int awake_count = Integer.parseInt(param[2]);

                // Обрабатываем звонки будильников.
                while (awake_count-- > 1) {
                    timers.add(timers.pollFirst() + timerDuration);
                    //for(Long tm:timers) System.out.println(tm);
                    //System.out.println();
                }
                long res = timers.first();
                System.out.println(res);
            }
        } catch (Exception e) {
        }
    }
}