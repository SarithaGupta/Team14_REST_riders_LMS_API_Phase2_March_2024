Feature: Gets User by Program Batches

Background: Admin sets authorization to bearer token

@tag1
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID
	Given Admin creates GET Request with valid batch Id "<Scenario>"
	When Admin sends HTTPS Request with endpoint "<endpoint>"
	Then Admin receives 200 OK Status with response body.  
	
Examples:

| endpoint | Scenario |
|Gets_User_by_Program_Batches| Scenario |
	
@tag2	
Scenario Outline: Check if admin is able to get the Admins by program batches for invalid batch ID
	Given Admin creates GET Request  with invalid batchId
	When Admin sends HTTPS Request with endpoint "<endpoint>"
	Then Admin receives status 404 with Not Found error message "batchid not found"  
		
@tag3
Scenario Outline: Check if admin is able to get the Admins by program batches for valid batch ID with invalid endpoint
	Given Admin creates GET Request with valid batch Id
	When Admin sends HTTPS Request with invalid endpoint
	Then Admin receives status 404 with Not Found error message
	
@tag4
Scenario Outline: Check if admin is able to get the Admins for valid program Id
	Given Admin creates GET Request with valid program Id "<Scenario>"
	When Admin sends HTTPS Request with endpoint "<endpoint>"
	Then Admin receives 200 OK Status with response body. 
Examples:  
|endpoint|Scenario|   
|Gets_Users_for_Program|Scenario| 
	
@tag5
Scenario Outline: Check if admin is able to get the Admins for invalid program Id
	Given Admin creates GET Request with invalid program Id
	When Admin sends HTTPS Request with endpoint "<endpoint>"
	Then Admin receives status 404 with Not Found error message   
	
  
                                                     
	
	

	                                                           

