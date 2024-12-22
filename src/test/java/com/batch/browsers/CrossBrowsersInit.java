package com.batch.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CrossBrowsersInit {

    String url = "https://docs.google.com/document/d/1tUO8zPf2fL4zlxbma5ZbFheNNAeuTWZv0f3gxcSntZo/edit?tab=t.0#heading=h.tjr0crjmx3es";
    WebDriver driver;


    @BeforeSuite
    public void startBrowser(){
        String browser = System.getProperty("browser", "firefox");
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
    }

    @Test
    public void openURL() throws InterruptedException {
        driver.get(url);
        Thread.sleep(7000);
    }

    @AfterSuite
    public void closeChromeBrowser() {
        driver.close();
    }

}
