package pageFactory;


import elementsTest.commonElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

	AndroidDriver driver;
	public commonElement profile_btn;
	public commonElement profile_menu;
	public commonElement create_board_btn;
	public commonElement board_title_input;
	public commonElement board_create_btn;
	public homePage(AndroidDriver driver){
		this.driver = driver;
		WiniumElements();
	}
	public void WiniumElements(){
		profile_btn = new commonElement(By.xpath("//span[@title='Callum Gill (callumgill99)']"),driver);
		profile_menu= new commonElement(By.xpath("/html/body/div[3]/div/section/div/div/div/h2[1]"),driver);
		create_board_btn = new commonElement(By.cssSelector("div.board-tile"),driver);
		board_title_input = new commonElement(By.cssSelector(".nch-textfield__input"),driver);
		board_create_btn = new commonElement(By.xpath("/html/body/div[3]/div/section/div/form/button"),driver);



	}





}
