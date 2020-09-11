
package mock;

//initial data

import entity.Candidate;
import entity.Experience;
import entity.Fresher;
import entity.Intern;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Candidate> listCandidate = new ArrayList<Candidate>(){
        {
            add(new Experience(1, "John", "Cena", 1967, "Texas", "0198271829", "JohnInvisible@gg.com", 0, 7, "Invisible"));
            add(new Fresher(2, "Lisa", "Black", 1990, "Kyoto", "0928176281", "Lisa@kyoto.com.jp", 1, 2005, "Good", "Harvard University"));
            add(new Fresher(3, "Huy", "Pham", 1995, "Vietnam", "0928176381", "HuyPham@fpt.edu.vn", 1, 2002, "Fair", "FPT University"));
            add(new Intern(4, "Tony", "Dick", 2002, "Washington", "019281728", "TonyTony@gmail.com", 2, "SE", 7, "Washington University"));
            add(new Experience(5, "Adam", "Eva", 1988, "Vancouver", "0194271829", "AdamEva@gmail.com", 0, 5, "Pro Learner"));
            add(new Intern(6, "Mai", "Vu", 2000, "Hanoi", "019381728", "MaiVu@gmail.com", 2, "Digital Marketing", 8, "National Art University"));
            add(new Fresher(7, "Rose", "Winson", 1999, "Tokyo", "0328176281", "RoseWinson@kyoto.com.jp", 1, 2003, "Fair", "UIT University"));
        }    
    };
}
