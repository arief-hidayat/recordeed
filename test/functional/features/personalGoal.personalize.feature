Feature: Edit/Personalize My Personal Goal
  As a user
  I want to personalize my goal
  So it fits my needs and interests.

  @v1.1
  Scenario: Add more deed to my selected deeds
    Given I have an existing set of selected deeds
    When I add another deed from global pool of deeds
    Then I can have it in my selected deeds set
    And It is populated with default deed criteria


  @1.0
  Scenario: Remove (removable) deed from my selected deeds
    Given I have an existing set of selected deeds
    When I opt and confirm to remove one deed from my selected deeds
    Then I'm no longer see that deed in the set
    And All my existing record that belongs to the removed deeds will be gone


  @v1.1
  Scenario: Add more deed to my set of selected deed criteria
    Given I have an existing set of selected deed criteria
    When I add another deed criteria from global pool of deed criteria
    Then I can have it in my selected deed criterias set
    And It is populated with default deed criteria

  @1.0
  Scenario: Remove (removable) deed from my set of selected deed criteria
    Given I have an existing set of selected deed criteria
    When I opt and confirm to remove one deed criteria from my selected deed criteria
    Then I'm no longer see that deed in the set
    And All my existing record that belongs to the removed criteria will be gone

  @now
  Scenario: Simplify rating system
    Given I have deed criteria with a default rating system (scale of n [3 or 5])
    When I change to scale of m [1 or 3]
    Then I am only seeing rating 0 to m
    And All of the the existing record will be converted to this new rating system.

  @now
  Scenario: Change to more detailed rating system
    Given I have deed criteria with a default rating system (scale of n [1 or 3])
    When I change to scale of m [3 or 5]
    Then I am only seeing rating 0 to m
    And All of the the existing record will be converted to this new rating system.

