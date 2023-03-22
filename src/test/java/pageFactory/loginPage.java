package pageFactory;


import elementsTest.commonElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	AndroidDriver driver;
	public commonElement txt_username;
	public commonElement txt_password;
	public commonElement btn_continue;
	public commonElement btn_login ;
	public commonElement txt_login_error;
	public commonElement test;


	public loginPage(AndroidDriver driver) {
		this.driver = driver;
		WiniumElements();
	}
	public void WiniumElements(){
		txt_username = new commonElement(By.xpath("//*[@id=\"user\"]"),driver);
		txt_password = new commonElement(By.xpath("//*[@id=\"password\"]"),driver);
		btn_continue= new commonElement(By.xpath("//*[@id=\"login\"]"),driver);
		btn_login= new commonElement(By.xpath("//*[@id=\"login-submit\"]"),driver);
		txt_login_error= new commonElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/section/div[2]/div/section"),driver);


	}
}
