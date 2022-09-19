Feature: Cut products
  As a Manager
  I want to cut products when Customer buy product

  Background:
    Given the store ready to service customers
    And a product "Bread" with price 20.50 and stock of 5 exist
    And a product "Jam" with price 80.00 and stock of 10 exist
    And a product "Cookie" with price 50.00 and stock of 6 exist

  Scenario: Cut one product
    When Customer buy "Jam" with quantity 2
    Then "Jam" stock should be 8

