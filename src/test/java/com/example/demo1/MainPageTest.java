package com.example.demo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://plexusworldwide.com/product/slim-hunger-control-sweet-tea");

        mainPage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkPrice() {
        String price = mainPage.retailPrice.getText();
        assertEquals(price, "$98.00");

        String vipPrice = mainPage.vipPrice.getText();
        assertEquals(vipPrice, "$88.20");

        String ambPrice = mainPage.ambPrice.getText();
        assertEquals(ambPrice, "$79.00");

        WebElement logo = mainPage.logo;
        logo.click();

        String url = driver.getCurrentUrl();
        assertEquals(url, "https://plexusworldwide.com/?culture=en-US");
    }  
}
