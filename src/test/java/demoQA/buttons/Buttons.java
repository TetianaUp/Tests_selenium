package demoQA.buttons;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Buttons extends AbstractTestInit {
    @Test
    public void checkButtons(){
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//span[text()='Buttons]")).click();
        String actualURLButtons= driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/buttons", "URL isn't correct");


    }
}
