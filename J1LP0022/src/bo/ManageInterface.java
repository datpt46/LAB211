/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface ManageInterface {
    public void add(ArrayList<Candidate> candidates, int type);
    public void createExperience(ArrayList<Candidate> candidates, Candidate cd);
    public void createFresher(ArrayList<Candidate> candidates, Candidate cd);
    public void createIntern(ArrayList<Candidate> candidates, Candidate cd);
    public void search(ArrayList<Candidate> cd);
    public void displayListCandidate(ArrayList<Candidate> cd);
}
