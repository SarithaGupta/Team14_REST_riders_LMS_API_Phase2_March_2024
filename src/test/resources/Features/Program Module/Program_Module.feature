#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: ProgramModule
Background: Admin sets Authorization 

     @tag1
     Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
     Given Admin creates POST Request for the LMS with request body
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 201 Created Status with response 
     
     Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization   
     Given Admin creates POST Request for the LMS with request body with no authorization
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 401 Unauthorized status
     
     Scenario: Check if Admin able to create a program with invalid endpoint
     Given Admin creates POST Request for the LMS with request body
     When Admin sends HTTPS Request and  request Body with invalid endpoint
     Then Admin receives 404 not found  Status with message and boolean success details
     
     Scenario: Check if Admin able to create a program with already existing program name 
     Given Admin creates POST Request for the LMS with request body 
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 400 Bad Request Status with message and boolean success details
     
     Scenario: Check if Admin able to create a program with invalid request body
     Given Admin creates POST Request for the LMS with invalid request body
     When Admin send HTTPS Request and request Body with endpoint
     Then Admin receives 400 Bad Request Status
     
@tag2

Scenario: Check if Admin able to retrieve all programs with valid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint
Then Admin receives 200 ok

Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint
Then Admin receives 404 not found  Status with error message

Scenario: Check if Admin able to retrieve all programs without Authorization
 Given Admin creates GET Request for the LMS API without authorization
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 401 Status with response body as Unauthorized            

Scenario: Check if Admin able to retrieve a program with valid program ID
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint with programId
Then Admin receives 200 OK Status with response body  

 Scenario: Check if Admin able to retrieve a program with invalid program ID 
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with endpoint with invalid programId
 Then Admin receives 404 Not Found Status with message and boolean success detail
 
 Scenario: Check if Admin able to retrieve a program with invalid baseURI
 Given Admin creates GET Request for the LMS API with invalid url
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 404 Not Found Status with message and boolean success detail
 
 Scenario: Check if Admin able to retrieve a program with invalid Endpoint
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with a invalid endpoint
 Then Admin receives 404 Not Found Status with message and boolean success detail
 

@tag3
Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 200 OK Status with updated value in response body       

Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body
Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields
When Admin sends HTTPS Request with invalid endpoints
Then Admin receive 404 Not Found Status with message and boolean success details  
  
Scenario: Check if Admin able to update a program with invalid baseURI
Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields,invalid URI
When Admin sends HTTPS Request with valid endpoint
Then Admin receive 404 Not Found Status with message and boolean success details

Scenario: Check if Admin able to update a program without Authorization
Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields without auth
When Admin sends HTTPS Request with valid endpoint
Then Admin receives 401 Unauthorized

Scenario: Check if Admin able to update a program with  Valid program Name and request body
Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields
When Admin sends HTTPS Requests with valid endpoint
Then Admin receives 200 OK Status with updated value in response body

Scenario: Check if Admin able to update a program with  invalid program Name and request body
Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields
When Admin sends HTTPS Requests with invalid endpoint
Then Admin receive 404 Not Found Status with message and boolean success details

@tag4
Scenario: Check if Admin able to delete a program with valid programName
Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName
When Admin sends HTTPS Requests with endpoint
Then Admin receives 200 Ok status with message

Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName                             
Given Admin creates DELETE Request for the LMS API endpoint  and  invalid programName
When Admin send HTTPS Requests with invalid endpoint
Then Admin receive 404 Not Found Status with message and boolean success details
 
Scenario: Check if Admin able to delete a program with valid program ID
Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID
When Admin sends HTTPS Request with endpoint with ID
Then Admin receives 200 Ok status with message
 
 Scenario: Check if Admin able to delete a program with valid LMS API,invalid program ID
 Given Admin creates DELETE Request for the LMS API endpoint  and  invalid program ID
 When Admin sends HTTPS Request with endpoint with invalid ID
 Then Admin receive 404 Not Found Status with message and boolean success details
 
 Scenario: Check if Admin able to delete a program without Authorization
 Given Admin creates DELETE Request for the LMS API endpoint  and  valid programId without Auth
 When Admin sends HTTPS Request with endpoint with ID
 Then Admin receives 401 Unauthorized
 
 
     
     
     