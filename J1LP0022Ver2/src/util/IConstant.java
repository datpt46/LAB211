/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Administrator
 */
public interface IConstant {
    String TEXT = "^[A-Za-z0-9 ,\\.]+$";
    String NAME = "^[A-Za-z ]+$";
    String PHONE = "^[0-9]{10,11}$";
    String EMAIL = "^[A-Za-z]+[\\w]*@[A-Za-z]+(\\.[A-Za-z]+){1,3}$";
    String YES_NO = "^[yYnN]$";
}
