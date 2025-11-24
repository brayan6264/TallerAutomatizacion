package co.edu.udea.certificacion.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certificacion.moduloprueba.userinterfaces.TransactionHistoryPage.TRANSACTIONS_TABLE;

public class ValidateTransactionHistory implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return TRANSACTIONS_TABLE.resolveFor(actor).getText();
    }
    public static ValidateTransactionHistory tableContent() {
        return new ValidateTransactionHistory();
    }
}
