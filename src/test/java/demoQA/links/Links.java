package demoQA.links;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Links extends AbstractTestInit {
    public Links() {
    }

    @Test
    public void checkLinks() throws InterruptedException {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
        Thread.sleep(2000L);
        Set<String> windowHandles = this.driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindowHandle = (String) iterator.next();
        String secondWindowHandle = (String) iterator.next();
        this.driver.switchTo().window(secondWindowHandle);
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void checkDynamicLink() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='dynamicLink']")).click();
        Set<String> windowHandles = this.driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindowHandle = (String) iterator.next();
        String secondWindowHandle = (String) iterator.next();
        this.driver.switchTo().window(secondWindowHandle);
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void checkCreatedApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='created']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("201") && resultLine.getText().contains("Created"));
    }

    @Test
    public void checkNoContentApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='no-content']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("204") && resultLine.getText().contains("No Content"));
    }

    @Test
    public void checkMovedApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='moved']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("301") && resultLine.getText().contains("Moved Permanently"));
    }

    @Test
    public void checkBadRequestApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='bad-request']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("400") && resultLine.getText().contains("Bad Request"));
    }

    @Test
    public void checkUnauthorizedApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='unauthorized']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("401") && resultLine.getText().contains("Unauthorized"));
    }

    @Test
    public void checkForbiddenApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        this.driver.findElement(By.xpath("//a[@id='forbidden']")).click();
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("403") && resultLine.getText().contains("Forbidden"));
    }

    @Test
    public void checkNotFoundApiCall() {
        this.driver.get("https://demoqa.com/elements");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")));
        this.driver.findElement(By.xpath("//li[@id='item-5']//span[text()='Links']")).click();
        String actualURLButtons = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURLButtons, "https://demoqa.com/links", "URL isn't correct");
        scrollToElement(this.driver, this.driver.findElement(By.xpath("//a[@id='invalid-url']")));
        this.driver.findElement(By.xpath("//a[@id='invalid-url']")).click();
        WebElement resultLine = this.driver.findElement(By.xpath("//p[@id='linkResponse']"));
        Assert.assertTrue(resultLine.getText().contains("404") && resultLine.getText().contains("Not Found"));
    }
}
