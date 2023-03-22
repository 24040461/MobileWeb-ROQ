package steps;



import driverFactory.driverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.boardPage;
import pageFactory.global.globalElements;
import pageFactory.homePage;
import pageFactory.loginPage;

public class boardSteps {

    private loginPage login = new loginPage(driverFactory.getdriver());
    private globalElements global = new globalElements(driverFactory.getdriver());
    private boardPage board = new boardPage(driverFactory.getdriver());
    private homePage home = new homePage(driverFactory.getdriver());

    private static String storeTitle;
    @When("user clicks on create board")
    public void userClicksOnCreateBoard() {
        home.create_board_btn.click();
    }
    @Then("user enters board title {string}")
    public void userEntersBoardTitle(String title){
        home.board_title_input.type(title);
        storeTitle = title;
    }

    @And("user clicks on the create button")
    public void userClicksOnTheCreateButton(){
        home.board_create_btn.click();
    }

    @And("user can see the title matches with the title they created in step three")
    public void userCanSeeTheTitleMatchesWithTheTitleTheyCreatedInStepThree() {
        board.board_title.wordCompare(storeTitle);
    }
    @Then("user is taken to the board they just created")
    public void userIsTakenToTheBoardTheyJustCreated() {
        board.board_title.waitUnitIsDisplayed();
    }
}
