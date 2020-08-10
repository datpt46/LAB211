
package validation;

import java.util.Locale;
import java.util.Scanner;

//viet thuong la ngon ngu, viet hoa la country

public class Validate {

    static process.TPBankProcess tpp = new process.TPBankProcess();

    public String getString(Locale locale) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                tpp.getWordLanguage(locale, "checkEmptyString");
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
                    tpp.getWordLanguage(locale, "checkNumberRange");
                }

            } catch (NumberFormatException e) {
                tpp.getWordLanguage(locale, "checkEnterInputAgain");
            }
        }

        return number;
    }

    public String getAccount(Locale locale) {
        String account = "";
        boolean flag = true;

        while (flag) {
            tpp.getWordLanguage(locale, "enterAccount");
            account = getString(locale);
            if (account.matches("\\d{10}")) {
                flag = false;
            } else {
                tpp.getWordLanguage(locale, "errorAccount");
            }
        }
        return account;
    }

    private boolean isPassword(String pass) {
        int passLength = pass.length();
        boolean isPass = true;

        if (passLength >= 8 && passLength <= 31) {
            for (int i = 0; i < passLength; i++) {
                if (!Character.isLetter(pass.charAt(i)) && !Character.isDigit(pass.charAt(i))) {
                    isPass = false;
                    break;
                }
            }

            if (pass.matches("\\d+") || pass.matches("[a-zA-Z]+")) {
                isPass = false;
            }
        } else {
            isPass = false;
        }
        return isPass;
    }

    public String getPassword(Locale locale) {
        String password = "";
        boolean flag = true;

        while (flag) {
            tpp.getWordLanguage(locale, "enterPassword");
            password = getString(locale);
            if (isPassword(password)) {
                flag = false;
            } else {
                tpp.getWordLanguage(locale, "errorPassword");
            }
        }
        return password;
    }

    public String getCaptcha(Locale locale) {
        boolean flag = true;
        String captchaInput = "";
        String captchaGenerated = "";

        while (flag) {
            captchaGenerated = tpp.generateCaptcha();
            System.out.println(captchaGenerated);

            tpp.getWordLanguage(locale, "enterCaptcha");
            captchaInput = getString(locale);

            if (captchaGenerated.equals(captchaInput)) {
                tpp.getWordLanguage(locale, "loginSuccess");
                flag = false;
            } else {
                tpp.getWordLanguage(locale, "errorCaptcha");
            }
        }

        return captchaInput;
    }

}
