package com.batch.mouse;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hover {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//a[@title='Women']"));

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();
        Thread.sleep(5000);
        WebElement dress = driver.findElement(By.xpath("//li[@class='sfHover']//a[@title='Casual Dresses'][normalize-space()='Casual Dresses']"));
        dress.click();

        Thread.sleep(5000);

    }

    @AfterSuite
    public void closeChromeBrowser() {
        driver.quit();
    }

}
