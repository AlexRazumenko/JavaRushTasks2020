package task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {


    public static void main(String[] args) {
        new Solution().recurse(132);
    }


    public void recurse(int n) {

        if (n < 2) return;
        int number = n;

        StringBuilder sb = new StringBuilder();

        for (int i = 2; ; i++) {
            if (number % i == 0) {
                sb.append(i).append(" ");
                System.out.print(sb.toString());
                number = number/i;
                recurse(number);
                break;
            }
        }
//        System.out.print(sb.toString().trim());
    }
}
