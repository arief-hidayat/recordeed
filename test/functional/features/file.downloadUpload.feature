Feature: Download & upload data
  As a user
  I want to download the data
  So that I can fill in the record offline and later reupload back

  Scenario: Download master data (personal goal, selected deeds, and selected deeds' criteria)
    Given I have created personal goal and complete the deeds selection
    When I opt to download the master data
    Then I can get the data in excel format
    And The file contains 'personal goal' worksheet
    And The file contains 'selected deed with the criteria' worksheet

  Scenario: Upload master data (personal goal, selected deeds, and selected deeds' criteria)
    Given I have created/updated an excel file containing master data
    When I opt to upload master data
    Then I can get a notification if the upload is successful or failed
    And  I could see the server data is updated with uploaded master data

  Scenario: Download recordeed for a particular personal goal
    Given I have created personal goal and complete the deeds selection
    When I opt to download recordeed for a particular personal goal
    Then I can get the data in excel format
    And The file contains several worksheet
    And The file contains 'selected deed with the criteria' worksheet


  Scenario: Upload recordeed for a particular personal goal
    Given I have created/updated an excel file containing recordeed for a particular personal goal
    When I opt to upload recordeed for a particular personal goal
    Then I can get a notification if the upload is successful or failed
    And  I could see the server data is updated with uploaded recordeed data


