package task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        for (int i = 2; i <= 37; i++) {
            try {
                if (!args[0].matches("\\w+")) {
                    System.out.println("incorrect");
                    return;
                }

                BigInteger number = new BigInteger(args[0], i);
                System.out.println(i);
                break;
            } catch (Exception e) {
                continue;
            }
        }
    }
}