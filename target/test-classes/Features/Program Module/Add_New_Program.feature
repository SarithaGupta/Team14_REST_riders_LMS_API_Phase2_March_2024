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
Feature: Post Request
Background: Admin sets Authorization 

     @tag1
     Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
     Given Admin creates POST Request for the LMS with request body
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 201 Created Status with response body
     
     @tag2
     Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization   
     Given Admin creates POST Request for the LMS with request body with no authorization
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 401 Unauthorized status
     
     
     @tag3
     Scenario: Check if Admin able to create a program with invalid endpoint
     Given Admin creates POST Request for the LMS with request body
     When Admin sends HTTPS Request and  request Body with invalid endpoint
     Then Admin receives 404 not found  Status with message and boolean success details
     
     @tag4
     Scenario: Check if Admin able to create a program with already existing program name 
     Given Admin creates POST Request for the LMS with request body 
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 400 Bad Request Status with message and boolean success details
     
     @tag5
     Scenario: Check if Admin able to create a program with invalid request body
     Given Admin creates POST Request for the LMS with invalid request body
     When Admin sends HTTPS Request and  request Body with endpoint
     Then Admin receives 400 Bad Request Status
     