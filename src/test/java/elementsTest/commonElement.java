package elementsTest;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class commonElement {
    private By Locator;
    AndroidDriver Driver;

    public commonElement(By locator, AndroidDriver driver){
        Locator = locator;
        Driver = driver;
    }
    public void click(){
        WebDriverWait wait = new WebDriverWait(Driver, (20));
        wait.until(ExpectedConditions.elementToBeClickable(this.Locator));
        Driver.findElement(this.Locator).click();
    }

    public boolean isDisplayed(){
        boolean istrue =  Driver.findElement(this.Locator).isDisplayed();
        return istrue;
    }
    public void waitUnitIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(Driver, (20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.Locator));
    }
    public void type(String text){
        WebDriverWait wait = new WebDriverWait(Driver, (20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.Locator));
        Driver.findElement(this.Locator).sendKeys(text);
    }
    public void downArrow(){
        Driver.findElement(this.Locator).sendKeys(Keys.DOWN);
    }
    public void wordCompare(String wordCompare){
        Assert.assertEquals(wordCompare, Driver.findElement(this.Locator).getText());
    }
    public void enter(){
        Driver.findElement(this.Locator).sendKeys(Keys.ENTER);
    }
}
