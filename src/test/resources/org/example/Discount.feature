Feature: Applying a discount to the basket

  Background:
    Given I am logged in
    And I am on the website homepage


    Scenario: Applying discount to order
      Given I have a "cap" in my basket
      And I apply a discount code
      Then The correct prices are shown

