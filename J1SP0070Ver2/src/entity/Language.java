/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ResourceBundle;

/**
 *
 * @author Administrator
 */
public class Language {

    public String account;
    public String accountInvalid;
    public String password;
    public String passInvalid;
    public String captcha;
    public String captchaInvalid;
    public String login;
    public String loginFail;
    public String emptyString;

    {
        ResourceBundle rs = ResourceBundle.getBundle("ulities/Language");
        account = rs.getString("enterAccount");
        accountInvalid = rs.getString("errorAccount");
        password = rs.getString("enterPassword");
        passInvalid = rs.getString("errorPassword");
        captcha = rs.getString("enterCaptcha");
        captchaInvalid = rs.getString("errorCaptcha");
        login = rs.getString("loginSuccess");
        loginFail = rs.getString("loginFail");
        emptyString = rs.getString("emptyString");
    }

}
