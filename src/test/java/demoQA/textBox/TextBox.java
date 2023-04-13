package demoQA.textBox;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBox extends AbstractTestInit {

    @Test
    public void checkTextBox() {
        driver.get("https://demoqa.com/links");

        String textCurrentAddress = "801 PUCKER ST " + "WARRENSBURG NY 12885-5138 " + "USA";
        String textPermanentAddress = "601 CHAZY LAKE RD " + "SARANAC NY 12981-2907 " + "USA";

        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Full Name']"))
                .sendKeys("Tetiana Stanko");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']"))
                .sendKeys("wether123@vb.mk");
        WebElement currentAddress = driver
                .findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        WebElement permanentAddress = driver
                .findElement(By.xpath("//textarea[@id='permanentAddress']"));
        currentAddress.sendKeys(textCurrentAddress);
        permanentAddress.sendKeys(textPermanentAddress);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        WebElement name = driver.findElement(By
                .xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='name']"));
        String stringName = name.getText();
        WebElement email = driver.findElement(By
                .xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='email']"));
        String stringEmail = email.getText();
        WebElement currentAddressGet = driver.findElement(By
                .xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='currentAddress']"));
        String stringCurrentAddress = currentAddressGet.getText();
        WebElement permanentAddressGet = driver.findElement(By
                .xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='permanentAddress']"));
        String stringPermanentAddress = permanentAddressGet.getText();

        Assert.assertTrue(stringName.contains("Tetiana Stanko"));
        Assert.assertTrue(stringEmail.contains("wether123@vb.mk"));
        Assert.assertTrue(stringCurrentAddress.contains("801 PUCKER ST"));
        Assert.assertTrue(stringPermanentAddress.contains(textPermanentAddress));

        driver.quit();
    }
}
