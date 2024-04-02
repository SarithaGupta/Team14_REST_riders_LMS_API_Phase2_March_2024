@tag1
Feature: to retrieve all Batches

Background: Admin sets Authorization to Bearer Token.
 
  Scenario: Check all Batches retrieved or not
    Given User creates a GET request for valid endpoints
    When User sends GET request
    Then User recieves 200 OK Status
   
  @tag2
   Scenario: Check if admin able to retrieve all batches with invalid Endpoint
   Given Admin creates GET Request 
    When Admin sends GET HTTPS Request with invalid endpoint 
    Then Admin receives 404 status with error message Not Found .
    
 @tag3
   Scenario: Check if admin able to retrieve all batches with search string
   Given Admin creates GET Request with search string
    When Admin sends HTTPS Request with endpoint  
    Then Admin receives 200 Ok status with response body  
    
  @tag4 
   Scenario: Check if admin able to retrieve a batch with valid BATCH ID
   Given Admin creates GET Request with valid Batch ID
    When Admin sends HTTPS Request with endpoint with Batch ID 
    Then Admin receives 200 OK Status.                                                                  
    
   @tag5
   Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
   Given Admin creates GET Request with valid Batch Name
    When Admin sends HTTPS Request with endpoint with Batch Name
    Then Admin receives 200 OK Status for this.      
    
    @tag6
   Scenario: Check if admin able to retrieve a batch with valid Program ID
   Given Admin creates GET Request with valid Program Id
    When Admin sends HTTPS Request with endpoint with Program Id
    Then Admin receives 200 OK Status for this code.      
      
    
    
    
    
    
    
    
    
    
    
    
    