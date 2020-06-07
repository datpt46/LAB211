/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entity.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ValidateBoolean {
    public boolean isCandidateId(ArrayList<Candidate> candidates, String id) {
        for(Candidate cd : candidates) {
            if(id.equalsIgnoreCase(cd.getId())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCandidatePhone(ArrayList<Candidate> candidates, String phoneNumber) {
        for(Candidate cd : candidates) {
            if(phoneNumber.equals(cd.getPhone())) {
                return true;
            }
        }
        return false;
    }
    
     public boolean isCandidateEmail(ArrayList<Candidate> candidates, String email) {
        for(Candidate cd : candidates) {
            if(email.equals(cd.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
