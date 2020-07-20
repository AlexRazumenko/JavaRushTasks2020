package task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        if ((number > 3000) || (number <1 )) return;
        int[] threePowers = {1, 3, 9, 27, 81, 243, 729, 2187};
        List<Character> signs = new ArrayList<>();

        int remainder;
        int quotient = number;

        while (quotient > 0) {
            remainder = quotient % 3;
            quotient /= 3;
            switch (remainder) {
                case 0:
                    signs.add('0');
                    continue;
                case 1:
                    signs.add('+');
                    continue;
                case 2:
                    quotient += 1;
                    signs.add('-');
                    continue;
            }
        }

        StringBuilder sb = new StringBuilder(number + " =");
        for (int i = 0; i < signs.size(); i++) {
            if (!signs.get(i).equals('0')) {
                sb.append(" ").append(signs.get(i)).append(" ").append(threePowers[i]);
            }
        }
        System.out.println(sb.toString());
    }
}