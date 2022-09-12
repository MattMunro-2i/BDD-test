Feature: Placing an order

  Scenario: Ordering an item
    Given I have an order in my basket
    When I place the order
    Then I get an order number
    And The order appears in my orders