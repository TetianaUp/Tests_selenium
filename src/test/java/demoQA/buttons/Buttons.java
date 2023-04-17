package demoQA.buttons;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons extends AbstractTestInit {
    @Test
    public void checkButtons() {
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//span[text()='Buttons']")).click();
        String actualURLButtons = driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/buttons", "URL isn't correct");

        Actions action = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        action.doubleClick(doubleClick).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText(),
                "You have done a double click");

        WebElement rightClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        action.contextClick(rightClick).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText(),
                "You have done a right click");

        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText(),
                "You have done a dynamic click");
    }
}
