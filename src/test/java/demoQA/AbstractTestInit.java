package demoQA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;

public class AbstractTestInit {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Start set up driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        String downloadFilepath =  System.getProperty("user.dir"+ File.separator+
                "src/test/java/demoQA/uploadAndDownloadFiles");
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromeOptions.setExperimentalOption("prefs",chromePrefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        System.out.println("Finish set up driver");
    }

    @AfterMethod(alwaysRun = true)
    public void quiteDriver() {
        driver.quit();
        System.out.println("Quite driver");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
