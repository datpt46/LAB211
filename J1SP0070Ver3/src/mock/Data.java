package mock;

import entity.Account;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Account> listAccount = new ArrayList<Account>() {
        {
            add(new Account("1029817261", "ahdi129YIUQWIE"));
            add(new Account("1039817261", "bhdi129YIUQWIE"));
            add(new Account("1049817261", "chdi129YIUQWIE"));
            add(new Account("1059817261", "dhdi129YIUQWIE"));
//            add(new Account(Helper.genAccount(10), Helper.genPassword(8)));
//            add(new Account(Helper.genAccount(10), Helper.genPassword(13)));
//            add(new Account(Helper.genAccount(10), Helper.genPassword(22)));
//            add(new Account(Helper.genAccount(10), Helper.genPassword(11)));
        }
    };
}
