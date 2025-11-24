#Author: Brayan Gomez and Juan Camilo Arboleda
#Language: en
Feature: User authentication
  As a registered user I want to log into the platform so that I can access my personal features

  Scenario: Successful user login
    Given I am on the BuggyCars platform
    When I provide valid credentials to access my account
    Then The system allows me to log in as a user