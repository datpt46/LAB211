/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Validate {

    static final Scanner IN = new Scanner(System.in);
    static final generate.Generate GC = new generate.Generate();
    static final String ACCOUNT_REGEX = "^\\d{10}$";
    static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";

    public void getWordLanguage(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("messages", locale);
        System.out.println(labels.getString(key));
    }

    public String getString(Locale locale) {

        while (true) {
            String result = IN.nextLine().trim();
            if (result.isEmpty()) {
                getWordLanguage(locale, "checkEmptyString");
            } else {
                return result;
            }

        }

    }

    public int getInt(Locale locale, int min, int max) {
        int number = 0;
        boolean flag = true;

        while (flag) {

            try {
                number = Integer.parseInt(getString(locale));
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    getWordLanguage(locale, "checkNumberRange");
                }

            } catch (NumberFormatException e) {
                getWordLanguage(locale, "checkEnterInputAgain");
            }
        }

        return number;
    }

    public String getAccount(Locale locale) {
        String account = "";
        boolean flag = true;

        while (flag) {
            account = getString(locale);
            if (account.matches(ACCOUNT_REGEX)) {
                flag = false;
            } else {
                getWordLanguage(locale, "errorAccount");
            }
        }
        return account;
    }

    public String getPassword(Locale locale) {
        String password = "";
        boolean flag = true;

        while (flag) {
            password = getString(locale);
            if (password.matches(PASSWORD_REGEX)) {
                flag = false;
            } else {
                getWordLanguage(locale, "errorPassword");
            }
        }
        return password;
    }

    public boolean isCaptcha(String captchaGenerated, String captchaInput) {
        return captchaGenerated.equals(captchaInput);
    }

    public String getCaptcha(Locale locale) {
        boolean flag = true;
        String captchaInput = "";
        String captchaGenerated = "";

        while (flag) {
            captchaGenerated = GC.generateCaptcha();
            System.out.println(captchaGenerated);

            getWordLanguage(locale, "enterCaptcha");
            captchaInput = getString(locale);

            if (isCaptcha(captchaGenerated, captchaInput)) {
                getWordLanguage(locale, "loginSuccess");
                flag = false;
            } else {
                getWordLanguage(locale, "errorCaptcha");
            }
        }

        return captchaInput;
    }

}
