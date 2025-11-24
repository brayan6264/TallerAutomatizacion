package co.edu.udea.certificacion.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TransactionHistoryPage extends PageObject {
       public static final Target ACCOUNTS_OVERVIEW_LINK = Target.the("Accounts overview link").locatedBy("//*[@id='leftPanel']/ul/li[2]/a");
       public static final Target ACCOUNT_NUMBER_LINK = Target.the("Account number link").locatedBy("//*[@id='accountTable']/tbody/tr[1]/td[1]/a");
       public static final Target ACCOUNT_DETAILS_SECTION = Target.the("Account details section").locatedBy("//*[@id='accountDetails']/h1");
       public static final Target ACTIVITY_PERIOD_SELECT = Target.the("Activity Period select").locatedBy("//*[@id='month']");
       public static final Target TYPE_SELECT = Target.the("Type select").locatedBy("//*[@id='transactionType']");
       public static final Target GO_BUTTON = Target.the("Go button").locatedBy("//*[@id='activityForm']/table/tbody/tr[3]/td[2]/input");
       public static final Target TRANSACTIONS_TABLE = Target.the("Transactions table").locatedBy("//*[@id='transactionTable']");
}
