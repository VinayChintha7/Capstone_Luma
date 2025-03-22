@Cart
Feature: Cart Functionality

  Scenario: Clicking on Cart after adding a product
    Given User has added a product to the cart
    When User clicks on the cart icon
    Then Cart page should be displayed
