package util;

import java.util.Random;

public class Helper {

    public static void menu() {
        System.out.println("\n-------Login Program--------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    private static String genAlphaNumeric() {
        String alpha = "";
        String number = "0123456789";
        String alphaNumeric = "";
        char c = 'A';
        while (c <= 'Z') {
            alpha += c;
            c++;
        }
        alphaNumeric = alpha + alpha.toLowerCase() + number;
        return alphaNumeric;
    }

    public static String generateCaptcha(int length) {
        String alphaNumeric = genAlphaNumeric();
        String captchaGen = "";

        for (int i = 0; i < length; i++) {
            captchaGen += alphaNumeric.charAt(new Random().nextInt(alphaNumeric.length()));
        }

        return captchaGen;
    }

    public static String genAccount(int length) {
        String number = "0123456789";
        String account = "";

        for (int i = 0; i <= length; i++) {
            account += number.charAt(new Random().nextInt(number.length()));
        }

        return account;
    }

    public static String genPassword(int length) {
        String alphaNumeric = genAlphaNumeric();
        String password = "";

        for (int i = 0; i <= length; i++) {
            password += alphaNumeric.charAt(new Random().nextInt(alphaNumeric.length()));
        }

        return password;
    }

}
