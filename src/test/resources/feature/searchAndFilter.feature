Feature: Amazon.in Phone Search and Filter

  Scenario: Search for phones, apply filters, and validate the filtered list
    Given User is on the Amazon.in homepage
    When User searches for phone
    And User applies filters for "Brand: Samsung" and "Avg. Customer Review: 4 Stars & Up"
    Then The filtered list should only contain phones from Samsung with 4 stars and above
