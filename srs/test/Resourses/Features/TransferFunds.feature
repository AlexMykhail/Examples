Feature: Transfer Funds
  User of ZeroBank
  can have transfers through app

  Background:
  Given Login to the app with credentials
      |username|password|

  Scenario:
    Given User navigates to "Transfer Funds" page
    When randomly selects From account
    And randomly selects To account
    And sets amount "1000"
    And sets description "description"
    And clicks Continue button
    Then checks Input data
    And clicks Submit button
    Then "You successfully submitted your transaction." message is shown
