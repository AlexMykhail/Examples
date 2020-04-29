Feature: Add New Payee & Pay With Saved Payee


  Background:
    Given Login to the app with credentials
      |username|password|



  Scenario Outline: Add New Payee
    When User navigates to the "Add New Payee" page
    And User types "<payeeName>" as user's name
    And User types "<payeeAddress>" as address
    And User types "<payeeAccount>" as account number
    And User types "<payeeDetails>" as details
    And User clicks on Add button
    Then "The new payee <payeeName> was successfully created." success message is shown

    Examples:
      |payeeName|payeeAddress|payeeAccount|payeeDetails|
      |Alex     |Chicago     |123456      |123456      |




  Scenario: Pay With Saved Payee
    When User navigates to the "Pay Saved Payee" page
    And User randomly selects Payee
    And User randomly selects Account
    And User types "1000" as amount
    And User types "2020-04-04" as date
    And User types "description" as description
    And User clicks Pay button
    Then "The payment was successfully submitted." submit message is shown

