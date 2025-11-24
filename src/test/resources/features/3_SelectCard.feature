#Author: Brayan Gomez and Juan Camilo Arboleda
#Language: en
Feature: Car selection
  As a registered user I want to view the details of a specific car so that I can interact with its information

  Scenario: Successful car selection
    Given I am logged into the BuggyCars platform
    When I choose a car from the catalog
    Then the system should display the details of the selected car