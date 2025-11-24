#Author: Brayan Gomez and Juan Camilo Arboleda
#Lenguage:en

    Feature: Account creation
  As a user I want to create financial accounts so I can manage my money in Parabank.

      Background:
        Given I am logged into my Parabank account

      Scenario: Create initial Savings account
        When I request the creation of a Savings account
        Then the system confirms the creation of the Savings account

      Scenario: Create a Checking account
        When I request the creation of a Checking account
        Then the system confirms the creation of the Checking account