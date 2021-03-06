@Shopping
Feature: Do online shopping

@Shopping
Scenario: online shopping
Given User navigates to women category
When User applies filters
And User add selected items to cart
And Proceed to checkout
Then User enters shipping details
And User add incorrect payment details