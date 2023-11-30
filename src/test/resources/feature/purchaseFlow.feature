Feature: Amazon.in iPhone Purchase Flow

  Scenario: Search for iPhone, select, view product details, store price, and add to cart

    Given User is on the Amazon.in homepage
    When User searches for iphone
    And User selects an iPhone from the search results
    And User stores the price of the selected iPhone in a variable
    And User adds the iPhone to the cart
    Then The iPhone should be successfully added to the cart