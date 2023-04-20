package demoQA.radioButtons;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtons extends AbstractTestInit {

    @Test
    public void checkRadiButton() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, "https://demoqa.com/radio-button", "URL isn't correct");

        driver.findElement(By.xpath("//label[@for='yesRadio']/preceding-sibling::input/..")).click();
        WebElement selected = driver.findElement(By.xpath("//span[@class='text-success']"));

        Assert.assertTrue(selected.getText().contains("Yes"));

        driver.findElement(By.xpath("//label[@for='impressiveRadio']/preceding-sibling::input/.."))
                .click();

        Assert.assertTrue(selected.getText().contains("Impressive"));

        WebElement disableButtonNo = driver.findElement(By.xpath("//label[@for='noRadio']/preceding-sibling::input/.."));
        if (disableButtonNo.isEnabled()) {
            System.out.println("Element is disabled");
        } else {
            System.out.println("Element is enabled");
        }

    }
}