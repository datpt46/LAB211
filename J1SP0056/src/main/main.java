package main;

import bo.ManageWorker;
import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import validation.Validate;

/**
 *
 * @author datpthe141311
 */
public class main {

    public static void main(String[] args) {
        
    validation.Validate check = new Validate();
    ManageWorker manage = new ManageWorker();
    ArrayList<Worker> lw = new ArrayList<Worker>();
    ArrayList<SalaryHistory> lsh = new ArrayList<SalaryHistory>();
        
        while (true) {
            manage.menu();
            int choose = check.getInt("please enter 1-5: ", 1, 5);
            switch (choose) {
                case 1:
                    manage.addWorker(lw, lsh);
                    break;
                case 2:
                    manage.changeSalary(lw, lsh, 1);
                    break;
                case 3:
                    manage.changeSalary(lw, lsh, 2);
                    break;
                case 4:
                    manage.getInformationSalary(lsh);
                    break;
                case 5:
                    return;
            }
        }

    }
}
