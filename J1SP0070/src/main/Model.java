/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Locale;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Model {
    
    private static final validation.Validate CHECK = new Validate();

    public void display() {
        Locale localeVi = new Locale("vi");
        Locale localeEn = new Locale("en");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.println("Please choice 1 option: ");
        int choice = CHECK.getInt(1, 3, localeEn);

        switch (choice) {
            case 1:
                runTPBank(localeVi);
                break;
            case 2:
                runTPBank(localeEn);
                break;
            case 3:
                return;
        }

    }

    public void runTPBank(Locale locale) {
        long accountNumber = CHECK.getAccountNumber(locale);
        String passWord = CHECK.getPassword(locale);
        String captchaGenerated = CHECK.generateCaptcha();
        while (true) {
            if (CHECK.isCaptcha(captchaGenerated, locale)) {
                CHECK.getWordLanguage(locale, "loginSuccess");
                return;
            } else {
                captchaGenerated = CHECK.generateCaptcha();
                CHECK.getWordLanguage(locale, "errorCaptcha");
            }
        }

    }
    
}
