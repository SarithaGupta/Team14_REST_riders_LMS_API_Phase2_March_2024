
@tag1
Feature: to create a Batche

 Scenario: To Check if a Batche is getting created or not
    Given Admin creates POST Request  with valid data in request body
    When Admin sends POST HTTPS Request with endpoint
    Then Admin receives {int} Created Status with response body of batch
    
    @tag2
    Scenario: Check if admin able to create a batch with invalid data in request body
    Given Admin creates POST Request with invalid data in request body
    When Sends HTTPS Request with endpoint 
    Then Admin receives 400 Bad Request Status with message and boolean success details