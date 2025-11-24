package co.edu.udea.certificacion.moduloprueba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
            "src/test/resources/features/SingUp.feature",
            "src/test/resources/features/AccountCreation.feature",
            "src/test/resources/features/Transactions.feature"
        },
        glue = "co.edu.udea.certificacion.moduloprueba.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)
public class RunnerOnlineBackingOperations {}