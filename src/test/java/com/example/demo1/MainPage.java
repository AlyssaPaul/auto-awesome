package com.example.demo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "[data-testid='price-component-value']")
    public WebElement retailPrice;

    @FindBy(css = "#purchase-buttons-and-options-container > section > div > label:nth-child(2) > div.PurchaseRadioButton_priceButtonContainer__AMVCb > div > div")   
    public WebElement vipPrice;
    
    @FindBy(css = "#purchase-buttons-and-options-container > section > div > label:nth-child(3) > div.PurchaseRadioButton_priceButtonContainer__AMVCb > div > div")   
    public WebElement ambPrice;

    @FindBy(css = "#__next > div > header > nav > div.MuiGrid-root.MuiGrid-container.css-1lizpo9 > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.css-10p3pq5 > a > div > div > span > img")  
    public WebElement logo;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
