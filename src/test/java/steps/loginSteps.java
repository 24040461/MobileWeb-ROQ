package steps;

import io.cucumber.java.en.And;
import pageFactory.global.globalElements;
import pageFactory.loginPage;
import driverFactory.driverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginSteps {
    AndroidDriver driver;
    driverFactory browsers;


    private loginPage login = new loginPage(driverFactory.getdriver());
    private globalElements global = new globalElements(driverFactory.getdriver());


    @Given("user is on login page")
    public void iAmOnTrelloPage() {
        driverFactory.getdriver().get("https://trello.com/login");
    }

    @When("user enters email {string}")
    public void userEntersEmail(String text) {
        login.txt_username.type(text);
    }

    @And("user clicks continue")
    public void userClicksContinue() {
        login.btn_continue.click();
    }

    @And("user enters password {string}")
    public void userEntersPassword(String text) {
        login.txt_password.type(text);
        login.btn_login.click();
    }

    @Then("user navigated to the home")
    public void userNavigatedToTheHome() {
        global.profileBtn.waitUnitIsDisplayed();
    }


    @And("user enters incorrect password {string}")
    public void userEntersIncorrectPassword(String text) {
        login.txt_password.type(text);
        login.btn_login.click();
    }

    @Then("user is shown incorrect message")
    public void userIsShownIncorrectMessage() {
        login.txt_login_error.waitUnitIsDisplayed();
    }
}
