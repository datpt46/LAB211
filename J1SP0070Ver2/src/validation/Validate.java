package validation;

import entity.Language;
import java.util.Scanner;

//viet thuong la ngon ngu, viet hoa la country
public class Validate {

    static final Scanner IN = new Scanner(System.in);

    public String getString() {
        while (true) {
            String result = IN.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println(new Language().emptyString);
            }
        }
    }

    public int getInt(int min, int max) {
        int number = 0;
        boolean flag = true;

        while (flag) {

            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println("number out of range");
                }

            } catch (NumberFormatException e) {
                System.out.println("number invalid");
            }
        }

        return number;
    }

    public boolean isAccount(String account) {
        return account.matches("\\d{10}");
    }

    public boolean isPassword(String pass) {
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
    
    public boolean isValidCaptcha(String captchaGenerated, String captchaInput){
        return captchaGenerated.equals(captchaInput);
    }
}
