
@tag1
Feature: to delete a Batche

Background: Admin sets Authorization to Bearer Token.
 
  Scenario: Check if admin able to delete a Batch with valid Batch ID
    Given Admin creates DELETE Request with valid BatchId
    When Admin sends DELETE HTTPS Request  with endpoint
    Then Admin receives 200 Ok status with message
 
