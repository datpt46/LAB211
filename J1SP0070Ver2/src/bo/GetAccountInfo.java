
package bo;

import entity.Language;
import ulities.GenerateCaptcha;

/**
 *
 * @author Administrator
 */
public class GetAccountInfo {

    static validation.Validate validate = new validation.Validate();
    Language language = new Language();

    public String getAccount() {
        System.out.println(language.account);
        String account = validate.getString();
        while (!validate.isAccount(account)) {
            System.out.println(language.accountInvalid);
            account = validate.getString();
        }
        return account;
    }

    public String getPassword() {
        System.out.println(language.password);
        String password = validate.getString();
        while (!validate.isPassword(password)) {
            System.out.println(language.passInvalid);
            password = validate.getString();
        }
        return password;
    }

    public String getCaptcha() {
        GenerateCaptcha gc = new GenerateCaptcha();
        String genCaptcha = gc.generateCaptcha();
        System.out.println(language.captcha + genCaptcha);
        String captcha = validate.getString();
        while (!validate.isValidCaptcha(genCaptcha, captcha)) {
            genCaptcha = gc.generateCaptcha();
            System.out.println(language.captcha + genCaptcha);
            captcha = validate.getString();
        }
        return captcha;
    }

    public void loginSuccess() {
        System.out.println(language.login);
    }
}
