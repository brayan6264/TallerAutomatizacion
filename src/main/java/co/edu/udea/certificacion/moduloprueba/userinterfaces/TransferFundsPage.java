package co.edu.udea.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TransferFundsPage extends PageObject {
    public static final Target TRANSFER_FUNDS_LINK = Target.the("Transfer Funds link").locatedBy("//*[@id='leftPanel']/ul/li[3]/a");
    public static final Target AMOUNT_INPUT = Target.the("Amount input").locatedBy("//*[@id='amount']");
    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("From account dropdown").locatedBy("//*[@id='fromAccountId']");
    public static final Target TO_ACCOUNT_DROPDOWN = Target.the("To account dropdown").locatedBy("//*[@id='toAccountId']");
    public static final Target TRANSFER_BUTTON = Target.the("Transfer button").locatedBy("//*[@id='transferForm']/div[2]/input");
    public static final Target CONFIRMATION_MESSAGE = Target.the("Transfer confirmation message").locatedBy("//*[@id='showResult']/h1");
}
