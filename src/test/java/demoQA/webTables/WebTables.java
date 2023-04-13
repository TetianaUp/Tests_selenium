package demoQA.webTables;

import demoQA.AbstractTestInit;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class WebTables extends AbstractTestInit {

    @Test
    @SneakyThrows
    public void checkWebTable() {
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demoqa.com/webtables", "URL isn't correct");

        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).sendKeys("Vega");
        Assert.assertTrue(getInformation("Vega"));
//        WebElement resultOfFiltering = driver.findElement(By.xpath("//div[@class='rt-tr -odd']"));
//        Assert.assertTrue(resultOfFiltering.getText().contains("Cierra"));


        driver.findElement(By.xpath("//span[@class='mr-2']")).click();
        sleep(2000);
        String headerRegistrationForm = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
        Assert.assertEquals(headerRegistrationForm, "Registration Form");


        driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Simona");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Venturo");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("simona@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Age']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("105");
        driver.findElement(By.xpath("//input[@placeholder='Department']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys("cleaner");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).clear();
    }

    public boolean getInformation(String parameter) {
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        boolean flag = true;
        for (WebElement element : tableRows) {
            if (!element.getText().contains(parameter)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

