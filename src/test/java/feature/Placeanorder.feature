Feature: I want to place an order

@E2EOrder
  Scenario: Validate the order confirmation message
    Given I launch the website
    When I login as a standard user "standard_user"
     And I  browse and add items to cart 
    And I validate if item is added to cart
    And I proceed to checkout
    And I enter the user information
    And I proceed to finish the checkout
    Then Validate the confirmation message
    
   
    
  