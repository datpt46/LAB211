
package bo;

//Business Object

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import util.Helper;

public class CandidateBo {
    private List<Candidate> list;

    public CandidateBo() {
    }

    public CandidateBo(List<Candidate> list) {
        this.list = list;
    }
    
//    display candidate
    public void display(){
        list.sort(Comparator.comparing(Candidate::getType));
        
        System.out.println("\n===============Experience============\n");
        for(Candidate c : this.list){
            if(c instanceof Experience){
                System.out.println(c.toString());
            }
        }
        
        System.out.println("\n===============Fresher============\n");
        for(Candidate c : this.list){
            if(c instanceof Fresher){
                System.out.println(c.toString());
            }
        }
        
        System.out.println("\n===============Intern============\n");
        for(Candidate c : this.list){
            if(c instanceof Intern){
                System.out.println(c.toString());
            }
        }
        
    }

    public void add(int type){
        Candidate c = null;
        
        do {
            switch(type){
                case 0:
                    c = new Experience();
                    break;
                case 1:
                    c = new Fresher();
                    break;
                case 2:
                    c = new Intern();
                    break;
            }
            c.create(list);
            list.add(c);
        }while(Helper.isContinue());
    }
    
////    search
    public List<Candidate> search(String searchName, int type){
        List<Candidate> searchList = new ArrayList<>();
        for(Candidate c:this.list){
            if(c.getFullName().contains(searchName) && type == c.getType()){
                searchList.add(c);
            }
        }
        return searchList;
    }
    
//    display search result
    public void displaySearchResult(List<Candidate> listResult){
        if(!listResult.isEmpty()){
            System.out.println("\nCandidate found!");
            listResult.forEach(System.out::println);
        } else {
            System.out.println("\nNot found!");
        }
    }
}
