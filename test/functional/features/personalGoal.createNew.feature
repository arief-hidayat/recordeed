Feature: Create New Personal Goal
  As a user
  I want create a personal goal
  So that I can keep track what I should focus on for each milestone and how far I have improved

  Scenario: Create goal from a special occasion milestone
    Given I have open personal goal form
    When I select a special occasion milestone
    Then I can specify the start & end date
    And I can select some deeds
    Then For each selected deeds, I can select criteria & override the rating system