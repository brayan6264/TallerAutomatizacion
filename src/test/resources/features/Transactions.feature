#Author: Brayan Gomez and Juan Camilo Arboleda
#Lenguage:en

    Feature: Funds transfer and transaction history
      As a user I want to transfer money between my accounts and view my transaction history.

      Background:
        Given I am logged into my Parabank account

      Scenario: Successful transfer
        When I transfer money from Savings to Checking
        Then the system confirms the transfer

      Scenario: Insufficient funds
        When I attempt to transfer more money than I have
        Then the system shows the result

      Scenario: View transaction history
        Given I have completed a transfer
        When I access the transaction history
        Then the system shows the recorded movement