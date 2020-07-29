/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface ManageWorkerInterface {
    public void addWorker(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh);
    public void changeSalary(ArrayList<Worker> lw, ArrayList<SalaryHistory> lh, int mode);
    public void getInformationSalary(ArrayList<SalaryHistory> lh);
}
