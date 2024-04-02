Feature: GET REQUEST(Admins by program batches)

Background: Admin sets authorization to No  Auth.

@tag1
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID with no authorization  	
	Given Admin creates GET Request with valid batch Id for "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>" 
	Then Admin receives status 401 with Unauthorized message for "<scenario>"
Examples:
|scenario                                                                                        |
|Check if admin is able to get the Admins by program batches for valid batch ID with no authorization|
	
@tag2
Scenario Outline: Check if admin is able to get the Admins for valid program Id without authorization
	Given Admin creates GET Request with valid program Id for "<scenario>"
	When Admin sends HTTPS Request with endpoint for "<scenario>" 
	Then Admin receives status 401 with Unauthorized message for "<scenario>"

Examples:
|scenario                                                                       |
|Check if admin is able to get the Admins for valid program Id without authorization|

@tag3
Scenario Outline: Check if admin is able to retreive Admins by valid role ID with no authorization
Given Admin creates GET Request with valid role ID for "<scenario>" 
When Admin sends HTTPS Request with endpoint for "<scenario>"
Then Admin receives status 401 with Unauthorized message for "<scenario>"

Examples:
|scenario                                                                       |
|Check if admin is able to retreive Admins by valid role ID with no authorization|

@tag4
Scenario Outline: Check if admin able to retrieve all Admins with roles with No authorization

