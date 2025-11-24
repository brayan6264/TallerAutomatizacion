#Author: Brayan Gomez and Juan Camilo Arboleda
#Lenguage:en

  Feature: User registration
  As a user I want to register in Parabank so I can access banking services.

      Scenario: Successful registration
        Given I am on the Parabank registration page
        When I complete the registration with valid information
        Then I saw the confirms that the account was created successfully