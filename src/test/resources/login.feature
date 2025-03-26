Feature: Login to Luma Magento website

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid "VK1234@gmail.com" and "Test@1234"
    And clicks the login button
    Then the user should be redirected to the account dashboard
