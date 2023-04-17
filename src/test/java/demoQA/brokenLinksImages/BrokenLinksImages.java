package demoQA.brokenLinksImages;

import demoQA.AbstractTestInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BrokenLinksImages extends AbstractTestInit {
    @Test
    public void checkValidImage() {
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")));
        driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/broken", "URL isn't correct");

        WebElement validImage = driver.findElement(By.xpath("//div[2]/img[1]"));

        assertTrue(validImage.isDisplayed());
    }

    @Test
    public void checkInvalidImage() {
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")));
        driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/broken", "URL isn't correct");

        WebElement validImage = driver.findElement(By.xpath("//div[2]/img[2]"));

        assertTrue(!validImage.isDisplayed());
    }

    @Test
    public void checkValidLink() {
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")));
        driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")).click();
        String actualURLButtons = driver.getCurrentUrl();

        assertEquals(actualURLButtons, "https://demoqa.com/broken", "URL isn't correct");

        driver.findElement(By.xpath("//a[text()='Click Here for Valid Link']")).click();

        assertEquals(driver.getCurrentUrl(), "https://demoqa.com/", "URL isn't correct");

        driver.navigate().back();
        driver.findElement(By.xpath("//a[text()='Click Here for Broken Link']")).click();

        assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/status_codes/500", "URL isn't correct");
        assertTrue(driver.findElement(By.xpath("//div[@class='example']")).getText().contains("500"));
    }


    @Test
    public void verifyBrokenImage() throws InterruptedException, IOException {
        driver.get("https://demoqa.com/elements");
        scrollToElement(driver,
                driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")));
        driver.findElement(By.xpath("//li[@id='item-6']//span[text()='Broken Links - Images']")).click();

        Thread.sleep(5000);

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());
        for (WebElement image : images) {
            String imageSrc = image.getAttribute("src");
            try {
                URL url = new URL(imageSrc);
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();

                if (httpURLConnection.getResponseCode() == 200) {
                    System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());
                } else {
                    System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " + httpURLConnection.getResponseMessage());
                }
                httpURLConnection.disconnect();
            } catch (Exception e) {
                System.err.println(imageSrc);
            }

        }
    }
}
