
@tag1
Feature: to update a Batch

Background: Admin sets Authorization to Bearer Token.
 
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
    Given Admin creates PUT Request with valid BatchId and Data
    When Admin sends PUT HTTPS Request  with endpoint
    Then Admin receives 200 OK Status with updated value in response body.                                         