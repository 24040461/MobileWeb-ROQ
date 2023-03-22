package runner.hooks;

import driverFactory.driverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.*;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class apphooks extends driverFactory {
    static String directory = System.getProperty("user.name");
    AndroidDriver driver;
    @BeforeAll
    public static void mobileSetup() throws MalformedURLException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723");
            Runtime.getRuntime().exec("cmd /c emulator.exe -avd " + "Pixel_4_API_28" + " -memory 4096", null, new File("C:\\Users\\" +directory + "\\Appdata\\local\\android\\sdk\\emulator"));
            Thread.sleep(7000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void launchNotePad() throws MalformedURLException, InterruptedException {
        driver = setUp();
        Thread.sleep(2000);
    }
    @After(order = 0)
    public void cleanUp() throws InterruptedException {
        driver.quit();
    }
    @After(order = 1)
    public void screenshot(Scenario scenario) {
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
    @AfterAll
    public static void end() throws IOException {
        Runtime.getRuntime().exec("cmd /c taskkill /F /IM qemu-system-x86_64.exe");
    }
}
