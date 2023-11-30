package com.pages;

import com.baseDriver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class searchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "(//span[@class= 'a-size-medium a-color-base a-text-normal'])[3]")
    private WebElement firstProduct;

    public searchResultsPage() {
        this.driver = BaseDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        firstProduct.click();

        handleNewTab();
    }

    private void handleNewTab() {
        // Get the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Check if there are multiple windows
        if (allWindowHandles.size() > 1) {
            // Switch to the new window
            for (String windowHandle : allWindowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }
        // Now, driver is focused on the new tab/window
    }
}