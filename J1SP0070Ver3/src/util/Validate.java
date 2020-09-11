package util;

import java.util.Scanner;

public class Validate {

    private static Scanner scanner = new Scanner(System.in);

    public Validate() {
    }

    /**
     *
     * @param message display to the screen
     * @param min smallest integer number
     * @param max largest integer number
     * @return integer number in range
     */
    public static int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.err.println("number out of range!");
            } catch (NumberFormatException e) {
                System.err.println("number invalid!");
            }
        }
    }

    /**
     *
     * @param message input message
     * @param messageError error message
     * @param REGEX regex pattern to test String matches or not. e.g: phone,
     * email, v.v,...
     * @return String value with no-space in leading and trailing
     */
    public static String getString(String message, String messageError, final String REGEX) {
        while (true) {
            System.out.println(message);
            String str = scanner.nextLine();
            String str_trim = str.trim();
            if (str_trim.matches(REGEX)) {
                return str_trim;
            } else {
                System.err.println(messageError);
            }
        }
    }

    /**
     *
     * @param message info
     * @param messageError error
     * @param captchaGenerate true if captcha input match captcha generate
     * @return
     */
    public static boolean verifyCaptcha(String message, String messageError, String captchaGenerate) {
        String captchaInput;
        while (true) {
            System.out.println(message);
            captchaInput = scanner.nextLine().trim();
            if (captchaGenerate.equals(captchaInput)) {
                break;
            }
            System.err.println(messageError);
        }
        return true;
    }
}
