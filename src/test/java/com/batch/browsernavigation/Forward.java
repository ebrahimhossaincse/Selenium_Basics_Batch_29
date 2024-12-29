package com.batch.browsernavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Forward {

    WebDriver driver;

    @BeforeSuite
    public void startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(5000);

        driver.navigate().to("https://www.daraz.com.bd/?m_station=page#?");
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);

        driver.navigate().forward();
        Thread.sleep(5000);

    }

    @AfterSuite
    public void closeChromeBrowser() {
        driver.quit();
    }

}
