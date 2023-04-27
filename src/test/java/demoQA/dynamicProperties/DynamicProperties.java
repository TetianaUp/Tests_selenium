package demoQA.dynamicProperties;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicProperties extends AbstractTestInit {

    @Test
    public void checkDynamicButtons() throws InterruptedException {
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-8']//span[text()='Dynamic Properties']")));
        driver.findElement(By.xpath("//li[@id='item-8']//span[text()='Dynamic Properties']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/dynamic-properties", "URL isn't correct");

        WebElement willEnable5SecBtn = driver.findElement(By.xpath("//button[@id='enableAfter']"));

        WebElement colorChangBtn = driver.findElement(By.xpath("//button[@id='colorChange']"));


        assertTrue(!willEnable5SecBtn.isEnabled());

        String coloButton = colorChangBtn.getCssValue("color");

        assertEquals(coloButton, "rgba(255, 255, 255, 1)", "Color is not white");

        Thread.sleep(5000);
        String newColorButton = colorChangBtn.getCssValue("color");
        WebElement visibleAfter5SecBtn = driver.findElement(By.xpath("//button[@id='visibleAfter']"));

        assertTrue(willEnable5SecBtn.isEnabled());
        assertTrue(visibleAfter5SecBtn.isDisplayed());
        assertNotEquals(coloButton, newColorButton, "Color doesn't change");
    }
}
