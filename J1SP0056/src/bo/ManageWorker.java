package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import java.util.Collections;
import validation.Validate;

/**
 *
 * @author datpthe141311
 */
public class ManageWorker {

    private static final validation.Validate CHECK = new Validate();

    //function 0
    public void menu() {
        System.out.println("======Worker Management======");
        System.out.println("1. Add worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information Salary");
        System.out.println("5. Exit");
    }

    //function 1
    public void addWorker(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh) {
        System.out.println("enter id: ");
        String id = CHECK.getWorker(lw);
        System.out.println("enter name: ");
        String name = CHECK.getString();
        int age = CHECK.getInt("enter age: ", 18, 50);
        double salary = CHECK.getDouble("enter salary: ", 0, Double.POSITIVE_INFINITY);
        System.out.println("enter worker location");
        String workerLocation = CHECK.getString();
        lw.add(new Worker(id, name, age, salary, workerLocation));
        lh.add(new SalaryHistory("ORIGIN", CHECK.getCurrentDate(), id, name, age, salary, workerLocation));

    }

    //function 2,3
    public void changeSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh, int mode) {
        //print list worker
        getInformationSalary(lh);

        //find worker to change salary
        System.out.println("enter id(code): ");
        String code = CHECK.getString();
        Worker worker = CHECK.getWorkerById(lw, code);

        if (worker != null) {
            //get worker current salary and declare salaryUpdate
            double currentSalary = worker.getSalary();
            double salaryUpdate;

            //mode 1: increase, mode2: decrease
            switch (mode) {
                case 1:
                    double salaryIncrease = CHECK.getDouble("enter ammount to increase: ", 0, Double.POSITIVE_INFINITY);
                    salaryUpdate = currentSalary + salaryIncrease;
                    lh.add(new SalaryHistory("UP", CHECK.getCurrentDate(),
                            worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
                    worker.setSalary(salaryUpdate);
                    System.out.println("Updated!");
                    getInformationSalary(lh);
                    break;
                case 2:
                    double salaryDecrease = CHECK.getDouble("enter ammount to decrease: ", 0, Double.POSITIVE_INFINITY);

                    if (currentSalary >= salaryDecrease) {
                        salaryUpdate = currentSalary - salaryDecrease;
                        lh.add(new SalaryHistory("DOWN", CHECK.getCurrentDate(),
                                worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
                        System.out.println("Updated!");
                        worker.setSalary(salaryUpdate);
                        getInformationSalary(lh);
                    } else {
                        System.out.println("Your salary you input is: " + salaryDecrease + " cannot higher than current salary: " + currentSalary);
                    }

                    break;
            }
        } else {
            System.out.println("worker not exist!");
        }
    }

    //function 4
    public void getInformationSalary(ArrayList<SalaryHistory> lh) {
        if (lh.isEmpty()) {
            System.out.println("nothing to show. list empty!");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s\n", "Code", "Name",
                "Age", "Salary", "Status", "Date");

        Collections.sort(lh);

        for (SalaryHistory sh : lh) {
            System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s\n", sh.getId(), sh.getName(),
                    sh.getAge(), sh.getSalary(), sh.getStatus(), sh.getDate());
        }
    }
}
