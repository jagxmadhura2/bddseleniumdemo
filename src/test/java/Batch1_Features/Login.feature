@Login
Feature: Login into the ZFJ Cloud Application

@Login
Scenario: Launch website
Given User Selects the Browser, Launches it and Maximises it
When User Navigates to the URL provided
Then Validate home page

@Login
Scenario: Sign in to website
Given User sign in using username and password