/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import validation.Validate;

/**
 *
 * @author Administrator
 */
public class Login implements LoginInterface {

    private static final String ALPHA = "abcdefghiklmnopqrstuvwxyz".toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String ALPHA_NUMERIC = ALPHA + DIGITS;

    //generate random number, list to store captcha, check function include String, integer,..
    private static final Random RD = new Random();
    private static final List<String> LIST_CAPTCHA = new ArrayList();
    private static final List<String> ACCOUNT = new ArrayList();
    private static final List<String> PASSWORD = new ArrayList();
    private static final validation.Validate CHECK = new Validate();

    public void menuLanguage() {
        System.out.println("----Login Program----");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public void menuTPBank() {
        System.out.println("----Check Login----");
        System.out.println("1. check account");
        System.out.println("2. check password");
        System.out.println("3. generate random captcha");
        System.out.println("4. check captcha");
        System.out.println("5. exit");
    }

    @Override
    public String checkAccountNumber(String accountNumber) {

        if (accountNumber.matches("\\d{10}")) {
            return accountNumber;
        } else {
            return "Account number must is a number and must have 10 digits";
        }
    }

    @Override
    public String checkPassword(String password) {

        if (password.matches("[a-zA-Z0-9]{8,31}")) {
            return password;
        } else {
            return "password must in range 8-31"
                    + " and contain only number and alphabet character";
        }
    }

    @Override
    public String generateCaptcha() {
        StringBuilder sb = new StringBuilder();

        int numberOfCharacters = CHECK.getInt("please enter random number of character: ", 0, Integer.MAX_VALUE);

        for (int i = 0; i < numberOfCharacters; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return RD.nextInt(max - min + 1) + min;
    }

//    public List<String> generateListCaptcha() {
//        LIST_CAPTCHA.clear();
//        String captchaValue = generateCaptcha();
//        LIST_CAPTCHA.add(captchaValue);
//        System.out.println("captcha: " + captchaValue);
//        
//        return LIST_CAPTCHA;
//    }

    public boolean isCorrectCaptcha(List<String> captcha, String inputCaptcha) {
        boolean flag = false;
        for (String cap : captcha) {
            if (cap.equals(inputCaptcha)) {
                flag = true;
            }
        }
        return flag;
    }
}
