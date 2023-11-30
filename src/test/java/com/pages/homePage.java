package com.pages;

import com.baseDriver.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search Amazon.in']")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public homePage() {
        this.driver = BaseDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }
}