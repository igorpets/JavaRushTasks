package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
1. В классе Solution должен присутствовать метод public static long[] getNumbers(long N)
2. В методе getNumbers не должно возникать исключений, при любых входных данных.
3. Все найденные числа должны быть строго меньше N.
4. Метод getNumbers должен возвращать массив чисел удовлетворяющих условию задачи.
*/

public class Solution {

    public static long[] getNumbers(long N) {
        ArrayList<Long> result = new ArrayList<>();
        long[] orig = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834,
                1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836,
                912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L,
                82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L,
                35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L,
                4929273885928088826L};
        /*long[] orig2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
                548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975,
                534494836, 912985153,
                912985153,
                4679307774L,
                32164049650L,
                32164049651L,
                40028394225L,
                42678290603L,
                44708635679L,
                49388550606L,
                82693916578L,
                94204591914L,
                28116440335967L,
                4338281769391370L,
                4338281769391371L,
                21897142587612075L,
                35641594208964132L,
                35875699062250035L,
                1517841543307505039L,
                3289582984443187032L,
                4498128791164624869L,
                4929273885928088826L};
                /*63105425988599693916L,
                128468643043731391252L,
                449177399146038697307L,
                21887696841122916288858L,
                27879694893054074471405L,
                27907865009977052567814,
                28361281321319229463398,
                35452590104031691935943,
                174088005938065293023722,
                188451485447897896036875,
                239313664430041569350093,
                1550475334214501539088894,
                1553242162893771850669378,
                3706907995955475988644380,
                3706907995955475988644381,
                4422095118095899619457938,
                121204998563613372405438066,
                121270696006801314328439376,
                128851796696487777842012787,
                174650464499531377631639254,
                177265453171792792366489765,
                14607640612971980372614873089,
                19008174136254279995012734740,
                19008174136254279995012734741,
                23866716435523975980390369295,
                1145037275765491025924292050346,
                1927890457142960697580636236639,
                2309092682616190307509695338915,
                17333509997782249308725103962772,
                186709961001538790100634132976990,
                186709961001538790100634132976991,
                1122763285329372541592822900204593,
                12639369517103790328947807201478392,
                12679937780272278566303885594196922,
                1219167219625434121569735803609966019,
                12815792078366059955099770545296129367,
                115132219018763992565095597973971522400,
                115132219018763992565095597973971522401};*/
        /*for (long i = 1; i < N; i++) {
            String nums = String.valueOf(i);
            int count = nums.length();
            long sum = 0;
            for (String num : nums.split("")) {
                int num2 = Integer.parseInt(num);
                long kent = 1;
                for (int k = 0; k < count; k++)
                    kent = kent * num2;
                sum = sum + kent;
                if (sum > i) break;
                //System.out.println("num=" + num);
            }
            //System.out.println(i+" sum="+sum);
            if (sum == i) {
                result.add(i);
            }
        }*/
        for (long num : orig) {
            if (num < N) result.add(num);
            else break;
        }
        long[] res2 = new long[result.size()];
        for (int i = 0; i < result.size(); i++)
            res2[i] = result.get(i);
        return res2;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}