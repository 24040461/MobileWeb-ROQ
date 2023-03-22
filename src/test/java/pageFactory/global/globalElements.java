package pageFactory.global;


import elementsTest.commonElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class globalElements {

    AndroidDriver driver;
    public commonElement profileBtn;
    public globalElements(AndroidDriver driver){
        this.driver = driver;
        WiniumElements();
    }
    public void WiniumElements(){
        profileBtn = new commonElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div/div[1]/div/h2"),driver);
    }
}
