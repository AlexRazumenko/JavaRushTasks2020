package task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 
Генератор паролей
*/
public class Solution {
    private static Random random = new Random();
    private static Set<String> passwords = new HashSet<>();

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String password;

        do {
            password = generatePassword(8);
        } while (passwords.contains(password));
        passwords.add(password);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(password.getBytes());
        } catch (IOException e) {

        }
        return baos;
    }

    private static String generatePassword(int length) {
        char[] passwordChars = new char[length];
        passwordChars[random.nextInt(length)] = getChar(97, 122);

        boolean success = false;
        while (!success) {
            int index = random.nextInt(length);
            if (passwordChars[index] == '\u0000') {
                passwordChars[index] = getChar(65, 90);
                success = true;
            }
        }

        success = false;
        while (!success) {
            int index = random.nextInt(length);
            if (passwordChars[index] ==  '\u0000') {
                passwordChars[index] = getChar(48, 57);
                success = true;
            }
        }

        char c;
        for (int i = 0; i < passwordChars.length; i++) {
            if (passwordChars[i] == '\u0000') {
                do {
                    c = getChar(48, 122);
                } while (!checkSymbol(c));
                passwordChars[i] = c;
            }
        }
        return new String(passwordChars);
    }

    private static char getChar(int leftBound, int rightBound) {
        int charIndex = (int) (random.nextFloat() * (rightBound - leftBound + 1)) + leftBound;
        return (char) charIndex;
    }

    private static boolean checkSymbol(int code) {
        return ((code > 47) && (code < 57)) || ((code > 64) && (code < 91)) || ((code > 96) && (code < 123));
    }
}