#Author: Brayan Gomez and Juan Camilo Arboleda
#Language: en
Feature: Post a car review
  As a registered user I want to leave my feedback on a car so that other users can read my experience

  Scenario: Successful car comment submission
    Given I am viewing the details of a selected car
    When I submit a comment about that car
    Then the system should confirm that my comment was successfully saved