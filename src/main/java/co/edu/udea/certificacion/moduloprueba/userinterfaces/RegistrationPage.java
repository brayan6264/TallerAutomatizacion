package co.edu.udea.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegistrationPage extends PageObject {
    public static final Target REGISTER_LINK = Target.the("Register link").locatedBy("//*[@id='loginPanel']/p[2]/a");
    public static final Target FIRST_NAME_INPUT = Target.the("First Name input").locatedBy("//*[@id='customer.firstName']");
    public static final Target LAST_NAME_INPUT = Target.the("Last Name input").locatedBy("//*[@id='customer.lastName']");
    public static final Target ADDRESS_INPUT = Target.the("Address input").locatedBy("//*[@id='customer.address.street']");
    public static final Target CITY_INPUT = Target.the("City input").locatedBy("//*[@id='customer.address.city']");
    public static final Target STATE_INPUT = Target.the("State input").locatedBy("//*[@id='customer.address.state']");
    public static final Target ZIP_CODE_INPUT = Target.the("Zip Code input").locatedBy("//*[@id='customer.address.zipCode']");
    public static final Target PHONE_INPUT = Target.the("Phone input").locatedBy("//*[@id='customer.phoneNumber']");
    public static final Target SSN_INPUT = Target.the("SSN input").locatedBy("//*[@id='customer.ssn']");
    public static final Target USERNAME_INPUT = Target.the("Username input").locatedBy("//*[@id='customer.username']");
    public static final Target PASSWORD_INPUT = Target.the("Password input").locatedBy("//*[@id='customer.password']");
    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Confirm Password input").locatedBy("//*[@id='repeatedPassword']");
    public static final Target REGISTER_BUTTON = Target.the("Register button").locatedBy("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input");
    public static final Target SUCCESSFUL_REGISTRATION_TXT = Target.the("Text of registration is successful").locatedBy("//*[@id='rightPanel']/h1");
    public static final Target ERROR_MESSAGE_TXT = Target.the("Error message").locatedBy("//*[@id='repeatedPassword.errors']");
}
