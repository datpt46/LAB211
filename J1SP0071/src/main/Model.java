/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.TaskManageBo;
import entity.Task;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Model {
    static int id = 1;
 //   static ArrayList<Task> taskList = new ArrayList<>();
    
    public void runningTaskManagement(){
        TaskManageBo tmb = new TaskManageBo();
        validation.getInput CHECK = new validation.getInput();
        ArrayList<Task> taskList = new ArrayList<>();
        while(true){
            tmb.menu();
            int choose = CHECK.getInt("enter 1-4", 1, 4);
            
            switch(choose){
                case 1:
                    tmb.addTask(taskList, id);
                    id+=1;
                    break;
                case 2:
                    tmb.deleteTask(taskList);
                    id-=1;
                    break;
                case 3:
                    tmb.displayTask(taskList);
                    break;
                case 4:
                    return;
            }
        }
    }
}
