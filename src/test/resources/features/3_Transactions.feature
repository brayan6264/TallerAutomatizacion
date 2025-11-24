#Author: Brayan Gomez and Juan Camilo Arboleda
#Lenguage:en

    Feature: Funds transfer and transaction history
      As a user I want to transfer money between my accounts and view my transaction history.

      Background:
        Given I am logged into my Parabank account

      Scenario: Successful transfer
        When I transfer money from Savings to Checking
        Then I saw the confirmation transfer

      Scenario: Insufficient funds
        When I attempt to transfer more money than I have
        Then I saw the result

      Scenario: View transaction history
        Given I have completed a transfer
        When I access the transaction history
        Then I saw  the recorded movement