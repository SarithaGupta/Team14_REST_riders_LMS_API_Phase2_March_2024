Feature: Gets User by Program Batches

Background: Admin sets authorization to bearer token

@tag1
Scenario: Check if admin is able to get the Admins by program batches for valid batch ID
	Given Admin creates GET Request with valid batch Id
	When Admin sends HTTPS Request with endpoint
	Then Admin receives 200 OK Status with response body.  
	
#@tag2	
#Scenario: Check if admin is able to get the Admins by program batches for invalid batch ID
#	Given Admin creates GET Request  with invalid batchId
#	When Admin sends HTTPS Request with endpoint
#	Then Admin receives status 404 with Not Found error message "batchid not found"  
#	
#@tag3
#Scenario: Check if admin is able to get the Admins by program batches for valid batch ID with no authorization  
#	
#	Given Admin creates GET Request with valid batch Id with no Auth
#	When Admin sends HTTPS Request with endpoint
#	Then Admin receives status 401 with Unauthorized message
#	
#@tag4
#Scenario: Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint
#	Given Admin creates GET Request with valid batch Id
#	When Admin sends HTTPS Request with invalid endpoint
#	Then Admin receives status 404 with Not Found error message
#
#	                                                           
#
