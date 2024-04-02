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
Feature: Get all programs
Background: Admin sets Authorization 

@tag1

Scenario: Check if Admin able to retrieve all programs with valid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint
Then Admin receives 200 ok

@tag2

Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint
Then Admin receives 404 not found  Status with error message

@tag3

Scenario: Check if Admin able to retrieve all programs without Authorization
 Given Admin creates GET Request for the LMS API without authorization
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 401 Status with response body as Unauthorized            

@tag4
Scenario: Check if Admin able to retrieve a program with valid program ID
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint with programId
Then Admin receives 200 OK Status with response body  

 @tag5
 Scenario: Check if Admin able to retrieve a program with invalid program ID 
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with endpoint with invalid programId
 Then Admin receives 404 Not Found Status with message and boolean success details
 
 @tag6
 Scenario: Check if Admin able to retrieve a program with invalid baseURI
 Given Admin creates GET Request for the LMS API with invalid url
 When Admin sends HTTPS Request with endpoint
 Then Admin receives 404 Not Found Status with message and boolean success details
 
 
 
 @tag7
 Scenario: Check if Admin able to retrieve a program without Authorization
 Given Admin creates GET Request for the LMS API without authorization
 When Admin sends HTTPS Request with endpoint with programId
 Then Admin receives 401 Unauthorized
 
 @tag8
 Scenario: Check if Admin able to retrieve a program with invalid Endpoint
 Given Admin creates GET Request for the LMS API
 When Admin sends HTTPS Request with a invalid endpoint
 Then Admin receives 404 Not Found Status with message and boolean success details
 
 
 
 
 
 
   

