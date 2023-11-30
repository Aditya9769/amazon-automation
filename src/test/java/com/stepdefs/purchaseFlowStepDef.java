package com.stepdefs;

import com.pages.homePage;
import com.pages.productDetailsPage;
import com.pages.searchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class purchaseFlowStepDef {

    homePage homepage = new homePage();
    searchResultsPage searchResultsPage = new searchResultsPage();
    productDetailsPage productDetailsPage = new productDetailsPage();
    String productPrice; // Variable to store product price

    @Given("User is on the Amazon.in homepage")
    public void userIsOnTheAmazonHomepage() {
        homepage.openHomePage("https://www.amazon.in/");
    }

    @When("User searches for iphone")
    public void userSearchesForIphone() {
        homepage.searchProduct();
    }

    @When("User selects an iPhone from the search results")
    public void userSelectsAnIPhoneFromTheSearchResults() {
        searchResultsPage.selectProduct();
    }

    @When("User stores the price of the selected iPhone in a variable")
    public void userStoresThePriceOfTheSelectediPhoneInAVariable() {
        productPrice = productDetailsPage.storeProductPrice();
        System.out.println("Product Price: " + productPrice);
    }

    @When("User adds the iPhone to the cart")
    public void userAddsTheIPhoneToTheCart() {
        productDetailsPage.addProductToCart();
    }

    @Then("The iPhone should be successfully added to the cart")
    public void theIPhoneShouldBeSuccessfullyAddedToTheCart() {
        Assert.assertTrue(productDetailsPage.isProductAddedToCart());
    }
}
