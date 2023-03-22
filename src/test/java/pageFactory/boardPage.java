package pageFactory;

import elementsTest.commonElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class boardPage {

	AndroidDriver driver;
	public commonElement board_title;

	public boardPage(AndroidDriver driver){
		this.driver = driver;
		WiniumElements();
	}
	public void WiniumElements(){
		board_title = new commonElement(By.xpath("//h1[@class='js-board-editing-target board-header-btn-text' and text()='Test']"),driver);
	}





}
