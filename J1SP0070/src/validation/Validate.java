/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Validate {

  //    private static final String REGEX_INT = "-?\\d+";
//    private static final String REGEX_DECIMAL = "-?\\d+\\.\\d+";
//    private static final String REGEX_DOUBLE = REGEX_INT + "|" + REGEX_DECIMAL;
    private static final Scanner SC = new Scanner(System.in);

    private static final Random RD = new Random();
    private static final String ALPHA = "abcdefghiklmnopqrstuvwxyz";
    private static final String ALPHA_UPPERCASE = ALPHA.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUMERIC = ALPHA + ALPHA_UPPERCASE + DIGITS;

    public void getWordLanguage(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("messages", locale);
        System.out.println(labels.getString(key));
    }

    public int getInt(int min, int max, Locale locale) {
        boolean flag = true;
        int number = 0;

        while (flag) {
            try {
                number = Integer.parseInt(SC.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    getWordLanguage(locale, "checkNumberRange");
                }
            } catch (NumberFormatException e) {
                getWordLanguage(locale, "checkEnterInputAgain");
            }
        }
        return number;
    }

    public String getString(Locale locale) {
        while (true) {
            String result = SC.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                getWordLanguage(locale, "checkEmptyString");
            }
        }
    }


    public long getAccountNumber(Locale locale) {
        boolean flag = true;
        long number = 0;

        while (flag) {
            getWordLanguage(locale, "enterAccount");
            String accountStr = SC.nextLine();

//            if (accountStr.isEmpty()) {
//                getWordLanguage(locale, "checkEmptyString");
//            } else
            {
                if (accountStr.matches("\\d{10}")) {
                    number = Integer.valueOf(accountStr);
                    flag = false;
                } else {
                    getWordLanguage(locale, "errorCheckInput");
                    getWordLanguage(locale, "checkEnterInputAgain");
                }
            }

        }
        return number;
    }

    public String getPassword(Locale locale) {

        String password = "";
        boolean flag = true;

        while (flag) {
            getWordLanguage(locale, "enterPassword");
            password = SC.nextLine();

//            if (password.isEmpty()) {
//                getWordLanguage(locale, "checkEmptyString");
//            } else 
            {
                if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,31}$")) {
                    flag = false;
                } else {
                    getWordLanguage(locale, "errorCheckPassWord");
                }
            }

        }

        return password;
    }

    public String generateCaptcha() {
        StringBuilder sb = new StringBuilder();
//        int numberOfCharacters = CHECK.getInt("please enter random number of character: ", 0, Integer.MAX_VALUE);
        for (int i = 0; i < 5; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return RD.nextInt(max - min + 1) + min;
    }

    public boolean isCaptcha(String captchaGenerated, Locale locale) {
        System.out.println(captchaGenerated);
        getWordLanguage(locale, "enterCaptcha");
        String captchaInput = getString(locale);

        return captchaGenerated.equals(captchaInput);
    }

}
