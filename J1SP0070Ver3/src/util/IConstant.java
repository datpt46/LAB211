
package util;


public interface IConstant {
    int CAPTCHA_LENGTH = 5;
    String ACCOUNT_NUMBER= "^[0-9]{10}$";
    String PASSWORD= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,31}$";
    String TEXT = "^[A-Za-z0-9 ,\\.]+$";
    String CAPTCHA = "^[A-Za-z0-9]{5}$";
}
