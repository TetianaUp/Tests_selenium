package demoQA.webTable;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class WebTable extends AbstractTestInit {
    public WebTable() {
    }

    @Test
    public void checkWebTable() throws InterruptedException {
        driver.get("https://demoqa.com/links");
        driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, "https://demoqa.com/webtables", "URL isn't correct");

        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).sendKeys("Vega");

        Assert.assertTrue(getInformation("Vega"));

        driver.findElement(By.xpath("//span[@class='mr-2']")).click();
        String headerRegistrationForm = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();

        Assert.assertEquals(headerRegistrationForm, "Registration Form");

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Gregor");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Gregor");
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']"))
                .sendKeys("simona@example.com");
        driver.findElement(By.xpath("//input[@placeholder='Age']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("105");
        driver.findElement(By.xpath("//input[@placeholder='Department']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys("cleaner");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Type to search']")).sendKeys("Gregor");

        Assert.assertTrue(getInformation("Gregor"));

    }

    public boolean getInformation(String parameter) {
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        boolean flag = true;
        Iterator var4 = tableRows.iterator();

        while (var4.hasNext()) {
            WebElement element = (WebElement) var4.next();
            if (!element.getText().contains(parameter)) {
                flag = false;
                break;
            } else flag = true;
        }

        return flag;
    }
}
