@Shopping
Feature: Do online shopping

Background: User is Logged In
 Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
Then Validate home page
Given User sign in using username and password

@Shopping
Scenario: online shopping
Given User navigates to women category
When User applies filters
And User add selected items to cart
And Proceed to checkout
Then User enters shipping details
And User add incorrect payment details