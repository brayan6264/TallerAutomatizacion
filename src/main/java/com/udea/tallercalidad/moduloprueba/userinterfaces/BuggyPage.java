package com.udea.tallercalidad.moduloprueba.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BuggyPage extends PageObject {
    public static final Target REGISTER_BOTTON = Target.the("Register Botton").locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/a");
    public static final Target USERNAME_TXTINP = Target.the("Username text input").locatedBy("//*[@id=\"username\"]");
    public static final Target FIRSTNAME_TXTINP = Target.the("Username text input").locatedBy("//*[@id=\"firstName\"]");
    public static final Target LASTNAME_TXTINP = Target.the("Username text input").locatedBy("//*[@id=\"lastName\"]");
    public static final Target PASSWORD_TXTINP = Target.the("Username text input").locatedBy("//*[@id=\"password\"]");
    public static final Target CONFIRMPASSWORD_TXTINP = Target.the("Username text input").locatedBy("//*[@id=\"confirmPassword\"]");
    public static final Target REGISTER_BTN = Target.the("Username text input").locatedBy("/html/body/my-app/div/main/my-register/div/div/form/button");
    public static final Target SUCCESSFUL_REGISTRATION_TXT = Target.the("Text of registration is successful").locatedBy("//div[contains(@class,'result') and contains(@class,'alert-success')]");
    public static final Target USERNAME_ALREADY_EXIST = Target.the("Text of registration is successful").locatedBy("//div[contains(@class,'result') and contains(@class,'alert-danger')]");
    public static final Target USERNAME_LOGIN_TXTINP = Target.the("Text username input field of the login user").locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]");
    public static final Target PASSWORD_LOGIN_TXTINP = Target.the("Text password username field of the login user").locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]");
    public static final Target TXT_HI_USERNAME = Target.the("text of login successfully").locatedBy("//span[contains(@class,'nav-link') and contains(., 'Hi')]");
    public static final Target CAR_IMAGE = Target.the("Car image to select").locatedBy("/html/body/my-app/div/main/my-home/div/div[2]/div/a");
    public static final Target TXT_CAR_DETAILS = Target.the("Text of card details").locatedBy("//h4[contains(text(),'Lamborghini')]");
    public static final Target COMMENT_TXTINP = Target.the("Input field of the comment").locatedBy("//*[@id=\"comment\"]");
    public static final Target BTN_SUBMIT_COMMENT = Target.the("Btn with text \"vote!\"").locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button");
    public static final Target COMMENT_SAVED_TXT = Target.the("Text of send comment").locatedBy("//table/tbody/tr[1]/td[3]");



}