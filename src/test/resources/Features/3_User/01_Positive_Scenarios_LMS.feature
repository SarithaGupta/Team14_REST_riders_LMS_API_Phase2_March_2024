Feature: User Module

Background: Admin sets authorization to bearer token

                                                     
@tag1
Scenario: Check if Admin able to generate token with valid credential
	Given Admin creates request with valid credentials
	When Admin calls Post Https method  with valid endpoint
	Then Admin receives 200 created with auto generated token
	
@tag2	
Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
Given Admin creates POST request with request body with all mandatory fields for "<scenario>"
When Admin sends HTTPS Request and  request Body with endpoint for "<scenario>"
Then Admin receives 201 Created Status with response body for "<scenario>".
Examples:
|scenario |                                                                
|Check if Admin able to create a program with valid endpoint and request body with Authorization|

@tag3 
Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
Given Admin creates POST request with request body with all mandatory fields for "<scenario>"
When Admin sends HTTPS Request and  request Body with endpoint for "<scenario>" 
Then Admin receives 201 Created Status with response body for "<scenario>".       
Examples:
|scenario |   
|Check if admin able to create a Batch with valid endpoint and request body (non existing values)|
	
@tag4
Scenario Outline: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields
Given Admin creates POST request with all mandatory fields for "<scenario>"  
When Admin sends HTTPS Request and  request Body with endpoint for "<scenario>"
Then Admin receives 201 Created Status with response body for "<scenario>".     

Examples:
|scenario |                                                                
|Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields|
	
@tag5
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID
	Given Admin creates GET Request with valid batch Id for "<scenario>" 
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 200 OK Status with response body for "<scenario>".  
	
Examples:

|scenario |
|Check if admin is able to get the Admins by program batches for valid batch ID | 

@tag6
Scenario Outline: Check if admin is able to get the Admins for valid program Id
	Given Admin creates GET Request with valid program Id for "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 200 OK Status with response body for "<scenario>". 
	
Examples:  

|scenario |   
|Check if admin is able to get the Admins for valid program Id| 

@tag7
Scenario Outline: Check if admin is able to retreive Admins by valid role ID
	Given Admin creates GET Request with valid role ID for "<scenario>"  
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 200 OK Status with response body for "<scenario>".   
	
Examples:  

|scenario |   
|Check if admin is able to retreive Admins by valid role ID|    

@tag8
Scenario Outline: Check if admin is able to retrieve all Admins with filters
Given Admin creates GET Request to retrieve all users with filters 
When Admin sends HTTPS Request with endpoint for "<scenario>"
Then Admin receives 200 OK Status with response body for "<scenario>".  

Examples:  

|scenario |   
|Check if admin is able to retrieve all Admins with filters|                                                            
