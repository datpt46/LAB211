/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author Administrator
 */
public interface LoginInterface {
//    void setLocate(Locate locate);
    String checkAccountNumber(String accountNumber);
    String checkPassword(String password);
    String generateCaptcha();
}