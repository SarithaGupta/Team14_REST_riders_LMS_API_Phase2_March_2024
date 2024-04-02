Feature:

Background: Admin sets authorization to bearer token

@tag1	
Scenario Outline: Check if admin is able to get the Admins by program batches for invalid batch ID
	Given Admin creates GET Request with invalid batchId
	When Admin sends HTTPS Request with endpoint for "<scenario>"
	Then Admin receives 404 Not Found Status with message and boolean success details for "<scenario>" 
	
Examples:  
  
|scenario |   
|Check if admin is able to get the Admins by program batches for invalid batch ID| 

@tag2
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint
	Given Admin creates GET Request with valid batch Id for "<scenario>"
	When Admin sends HTTPS Request with invalid endpoint for "<scenario>"
	Then Admin receives status 404 with Not Found error message for "<scenario>"
	
Examples:  
  
|scenario |   
|Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint| 

@tag3
Scenario Outline: Check if admin is able to get the Admins for invalid program Id
	Given Admin creates GET Request with invalid program Id
	When Admin sends HTTPS Request with endpoint for "<scenario>" 
	Then Admin receives 404 Not Found Status with message and boolean success details for "<scenario>" 
	
Examples:  
  
|scenario |   
|Check if admin is able to get the Admins for invalid program Id| 

@tag4
Scenario Outline: Check if admin is able to get the Admins for valid program Id with invalid endpoint  
	Given Admin creates GET Request with valid program Id for "<scenario>"
	When Admin sends HTTPS Request with invalid endpoint for "<scenario>"
	Then Admin receives status 404 with Not Found error message for "<scenario>"
	
Examples:  
  
|scenario |   
|Check if admin is able to get the Admins for valid program Id with invalid endpoint|

@tag5
Scenario Outline: Check if admin is able to retreive Admins by invalid role ID
Given Admin creates GET Request for GET with invalid role ID
When Admin sends HTTPS Request with endpoint for "<scenario>" 
Then Admin receives 404 Not Found Status with message and boolean success details for "<scenario>"

Examples:  
  
|scenario |   
|Check if admin is able to retreive Admins by invalid role ID|

@tag6
Scenario Outline: Check if admin is able to retreive Admins by valid role ID with invalid endpoint
Given Admin creates GET Request with valid role ID for "<scenario>" 
When Admin sends HTTPS Request with endpoint for "<scenario>" 
Then Admin receives status 404 with Not Found error message for "<scenario>"

Examples:  
  
|scenario |   
|Check if admin is able to retreive Admins by valid role ID with invalid endpoint|

@tag7
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID with no authorization  	
	Given Admin creates GET Request with valid batch Id for "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>" 
	Then Admin receives status 401 with Unauthorized message for "<scenario>"
Examples:
|scenario                                                                                        |
|Check if admin is able to get the Admins by program batches for valid batch ID with no authorization|
	
@tag8
Scenario Outline: Check if admin is able to get the Admins for valid program Id without authorization
	Given Admin creates GET Request with valid program Id for "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>" 
	Then Admin receives status 401 with Unauthorized message for "<scenario>"

Examples:
|scenario                                                                       |
|Check if admin is able to get the Admins for valid program Id without authorization|

@tag9
Scenario Outline: Check if admin is able to retreive Admins by valid role ID with no authorization
Given Admin creates GET Request with valid role ID for "<scenario>" 
When Admin sends HTTPS Request with endpoint for "<scenario>"
Then Admin receives status 401 with Unauthorized message for "<scenario>"

Examples:
|scenario                                                                       |
|Check if admin is able to retreive Admins by valid role ID with no authorization|



