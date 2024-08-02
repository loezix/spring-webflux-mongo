Feature: Customer retrieves Wishlist

  Scenario: Customer can retrieves his wishlist
    When the Customer retrieves his wishlist
    Then the Customer receives a list of wishes inside his wishlist

  Scenario: Customer can adds a product to his wishlist
    When the Customer adds a product to his wishlist
    Then the added product should be in his list of wishes
    And the Customer wishlist cannot exceed 20 items

  Scenario: Customer can remove a product from his wishlist
    When the Customer removes a product from his wishlist
    Then the removed product should not be in his list of wishes

  Scenario: Customer can check if an item is already is hist wishlist
    When the Customer verifies if a product is in his wishlist
    Then if the product exists, the message should be
    Then and if Not then the message should be

