/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entity.Task;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Validate {
    validation.getInput CHECK = new validation.getInput();
    
    public int findTaskById(ArrayList<Task> taskList){
        int id = CHECK.getInt("enter id: ", 1, taskList.size());
        for(int i=0; i<taskList.size(); i++){
            if(taskList.get(i).getId() == id){
                return i;
            }
        }
        System.out.println("id not found!");
        return -1;
    }
}
