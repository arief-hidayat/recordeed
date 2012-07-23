Feature: Create New Personal Goal
  As a user
  I want to create a personal goal (two modes: manual or automated)
  So that I can keep track what I should focus on for each milestone and how far I have improved

  @v1.1
  Scenario: Create goal from a special occasion milestone
    Given I have open personal goal form
    When I select a special occasion milestone
    Then I can specify the start & end date
    And I can select some deeds
    Then For each selected deeds, I can select criteria & override the rating system

  @now
  Scenario: Auto create personal goal for Ramadhan during registration
    Given I open registration page
    When I confirm the registration
    Then I am redirected to my personal goal page that is automatically created by the sytem
