
package main;

import java.util.Locale;
import java.util.ResourceBundle;
import service.LoginService;
import util.Helper;
import util.Validate;


public class TPBank {
    public static void start() {
        Helper.menu();
        int choice = Validate.getInt("Please enter 1-3: ", 1, 3);
        
        switch(choice){
            case 1:
                Locale.setDefault(new Locale("vi", "VN"));
                break;
            case 2:
                Locale.setDefault(new Locale("en", "US"));
                break;
            case 3:
                System.exit(0);
                break;
        }
        
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/Language");
        new LoginService().login(resourceBundle);
    }
}
