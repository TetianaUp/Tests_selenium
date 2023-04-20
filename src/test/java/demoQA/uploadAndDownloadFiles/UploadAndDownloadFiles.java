package demoQA.uploadAndDownloadFiles;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UploadAndDownloadFiles extends AbstractTestInit {

    @Test
    public void checkUploadFile(){
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-7']//span[text()='Upload and Download']")));
        driver.findElement(By.xpath("//li[@id='item-7']//span[text()='Upload and Download']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/upload-download", "URL isn't correct");

        String projectPath = System.getProperty("user.dir");
        driver.findElement(By.xpath("//input[@id='uploadFile']"))
                .sendKeys(projectPath+"/src/test/java/demoQA/uploadAndDownloadFiles/Виды+тестов+.pdf");

        assertTrue(driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText().contains("Виды+тестов+.pdf"));
    }

    @Test
    public void checkDownloadFile()throws InterruptedException{

        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-7']//span[text()='Upload and Download']")));
        driver.findElement(By.xpath("//li[@id='item-7']//span[text()='Upload and Download']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/upload-download", "URL isn't correct");

        driver.findElement(By.xpath("//a[@id='downloadButton']")).click();
        Thread.sleep(1000);
        //assertTrue(driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText().contains("Виды+тестов+.pdf"));
    }
}
