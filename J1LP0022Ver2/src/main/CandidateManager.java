
package main;

import bo.CandidateBo;
import mock.Data;
import util.Helper;
import util.IConstant;
import util.Validate;

public class CandidateManager {
    public static void start() {
//        init data
        CandidateBo candidateBo = new CandidateBo(Data.listCandidate);
        boolean flag = true;
        
        while(flag){
            Helper.menu();
            int choice = Validate.getInt("Enter choice 1-5: ", 1, 5);
            switch(choice){
                case 1:
                    candidateBo.add(0);
                    break;
                case 2:
                    candidateBo.add(1);
                    break;
                case 3:
                    candidateBo.add(2);
                    break;
                case 4:
                    candidateBo.display();
                    String searchName = Validate.getString("\nInput candidate name: ", "name invalid!", IConstant.NAME);
                    int searchType = Validate.getInt("Enter candidate type(0-2): ", 0, 2);
                    candidateBo.displaySearchResult(candidateBo.search(searchName, searchType));
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}
