#Author: Brayan Gomez and Juan Camilo Arboleda
  #Lenguage:en
  Feature: Create a new account
    As an unregistered user i want to create an account so that I can leave comments on the website

    Scenario: Successful user registration
      Given I am on the BuggyCars platform
      When I provide the necessary information to create a new account
      Then the system should confirm that my registration was completed successfully

    Scenario: Prevent account creation with an already registered username
      Given I am on the BuggyCars platform
      When I attempt to create a new account using a username that already exists
      Then the system should notify me that the username is already taken