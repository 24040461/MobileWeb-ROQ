package steps;


import driverFactory.driverFactory;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pageFactory.global.globalElements;
import pageFactory.homePage;
import pageFactory.loginPage;

public class profileSteps {

    private loginPage login = new loginPage(driverFactory.getdriver());
    private globalElements global = new globalElements(driverFactory.getdriver());
    private homePage home = new homePage(driverFactory.getdriver());
    @Given("user is on homepage of trello")
    public void user_is_on_homepage_of_trello(){
        driverFactory.getdriver().get("https://trello.com/login");
        login.txt_username.type("callumgill99@outlook.com");
        login.btn_continue.click();
        login.txt_password.type("Test1234");
        login.btn_login.click();
    }
    @When("user clicks on the profile")
    public void user_clicks_on_the_profile() {
        home.profile_btn.click();
    }
    @Then("user should see account options")
    public void user_should_see_account_options() {
        home.profile_menu.waitUnitIsDisplayed();
    }
}
