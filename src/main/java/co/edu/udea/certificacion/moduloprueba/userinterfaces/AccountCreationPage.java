package co.edu.udea.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AccountCreationPage extends PageObject {
    public static final Target OPEN_NEW_ACCOUNT_LINK = Target.the("Open New Account menu link").locatedBy("//a[contains(text(),'Open New Account')]");
    public static final Target ACCOUNT_TYPE_DROPDOWN = Target.the("Account type dropdown").locatedBy("//*[@id='type']");
    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("From account dropdown").locatedBy("//*[@id='fromAccountId']");
    public static final Target OPEN_ACCOUNT_BUTTON = Target.the("Open New Account button").locatedBy("//input[@type='button'][@value='Open New Account']");
    public static final Target CONFIRMATION_MESSAGE = Target.the("Confirmation message").locatedBy("//*[@id='openAccountResult']/h1[@class='title']"); 
    public static final Target NEW_ACCOUNT_ID = Target.the("New account ID").locatedBy("//*[@id='newAccountId']");
}
