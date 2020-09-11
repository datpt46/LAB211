
package util;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
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
    public static int getInt(String message, int min, int max){
        while(true){
            try {
                System.out.println(message);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <=max){
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
     * @param REGEX regex pattern to test String matches or not. e.g: phone, email, v.v,...
     * @return String value with no-space in leading and trailing
     */
    public static String getString(String message, String messageError, final String REGEX){
        while(true){
            System.out.println(message);
            String str = scanner.nextLine();
            String str_trim = str.trim();
            if (str_trim.matches(REGEX)){
                return str_trim;
            }
            System.err.println(messageError);
        }
    }
}
