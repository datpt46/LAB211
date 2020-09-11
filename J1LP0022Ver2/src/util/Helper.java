
package util;

import java.util.Calendar;

/**
 *
 * @author Administrator
 */
public class Helper {

    private Helper() {
    }
    
    public static void menu(){
        System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
    }
    
    public static boolean isContinue(){
        String c = Validate.getString("Do you want to continue (Y/N)?",
                "Y/N only!!", IConstant.YES_NO);
        return c.equalsIgnoreCase("y");
    }
    
    public static int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
