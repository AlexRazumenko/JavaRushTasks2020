package task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Main {
    public static boolean checkTelNumber(String telNumber) {

        if ((telNumber == null) || telNumber.contains("[a-zA-Z]")) return false;
        String strPattern = telNumber;
        int length = strPattern.replaceAll("\\D", "").length();

        if (length == 12) strPattern ="(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*\\-?\\d+\\-?\\d*$";
        else if (length == 10) strPattern = "^(\\d|\\(\\d{3}\\))?\\d*\\-?\\d+\\-?\\d*$";
        else return false;

        return telNumber.matches(strPattern);
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.println(checkTelNumber("+a38(050)1234567"));
        System.out.println(checkTelNumber("+38(050)n1234567"));
        System.out.println();
    }
}
