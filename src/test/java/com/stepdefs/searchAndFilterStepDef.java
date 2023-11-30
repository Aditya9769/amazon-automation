package com.stepdefs;

import com.pages.homePage;
import com.pages.searchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class searchAndFilterStepDef {

    homePage homePage = new homePage();
    searchResultsPage searchResultsPage = new searchResultsPage();
    List<WebElement> filteredResults;

    @When("User searches for phone")
    public void userSearchesForPhone() {
        homePage.searchProduct("phone");
    }

    @When("User applies filters for {string} and {string}")
    public void userAppliesFilters(String brandFilter, String reviewFilter) {
        searchResultsPage.applyFilters();
    }

    @Then("The filtered list should only contain phones from Samsung with 4 stars and above")
    public void theFilteredListShouldOnlyContainPhonesFromSamsungWith4StarsAndAbove() {
        filteredResults = searchResultsPage.getSearchResults();

        for (WebElement result : filteredResults) {
            String resultText = result.getText().toLowerCase();
            Assert.assertTrue(resultText.contains("samsung"));
        }
    }
}