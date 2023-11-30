package com.pages;

import com.baseDriver.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class productDetailsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@aria-hidden='true']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='rightCol']//div[35]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='a-box a-alert a-alert-success added-to-cart-message-box']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    private WebElement confirmationText;

    public productDetailsPage() {
        this.driver = BaseDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String storeProductPrice() {
        String price = productPrice.getText();
        return price;
    }

    public void addProductToCart() {
        addToCartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(confirmationText));
    }

    public boolean isProductAddedToCart() {
        return confirmationText.getText().contains("Added to Cart");
    }
}