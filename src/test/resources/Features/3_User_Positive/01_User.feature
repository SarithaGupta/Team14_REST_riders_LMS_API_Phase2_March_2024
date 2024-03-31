Feature: User Module

Background: 

@tag1
Scenario: Check if Admin able to generate token with valid credential
	Given Admin creates request with valid credentials
	When Admin calls Post Https method  with valid endpoint
	Then Admin receives 200 created with auto generated token
	
@tag2
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID
	Given Admin creates GET Request with valid batch Id 
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 200 OK Status with response body for "<scenario>".  
	
Examples:

|scenario |
|Check if admin is able to get the Admins by program batches for valid batch ID | 

@tag3
Scenario Outline: Check if admin is able to get the Admins for valid program Id
	Given Admin creates GET Request with valid program Id "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 200 OK Status with response body for "<scenario>". 
	
Examples:  

|scenario |   
|Check if admin is able to get the Admins for valid program Id| 

@tag4
Scenario Outline: Check if admin is able to retreive Admins by valid role ID
	Given