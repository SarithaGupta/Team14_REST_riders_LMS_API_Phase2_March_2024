Feature: Get request by AdminId

	//Get User deatils by user id
@tag1
  Scenario: Authorised Admin is able to retrieve admin details with AdminId
    Given Admin creates GET Request with valid AdminId
    When Admin sends HTTPS Request with valid endpoint
    Then Admin receives 200 OK Status with response body

  @tag2
  Scenario: Authorised Admin is able to retrieve admin details with AdminId invalid endpoint
   Given Admin creates GET Request with valid AdminId
   When Admin sends HTTPS Request with invalid endpoint
   Then Admin receives 404 OK Status with response body

  #@tag3
  #Scenario: Check if Authorised Admin is able to retrieve admin with valid AdminId with no Auth
    #Given Admin creates GET Request with valid AdminId and no auth
    #When Admin sends HTTPS Request with valid endpoint
    #Then Admin receives 401 OK Status with response body

	@tag4 
	Scenario: Verify if Authorised Admin able to retrieve a Admin with invalid Admin ID
	 Given Admin creates GET Request with invalid AdminId
   When Admin sends HTTPS Request with valid endpoint for invalid AdminId
   Then Admin receives status 404 with Not Found error message


	@tag5 
	Scenario: Verify if Authorised admin is able to update role id of a Admin by valid Admin id
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS Put Request with endpoint
	Then Admin receives 200 OK Status with response body

	@tag6
	Scenario: Verify if Authorised admin is able to update role id of a Admin with invalid request body
	Given Admin creates PUT Request with invalid request body
	When Admin sends HTTPS Put Request with endpoint
	Then Admin receives 400 Bad Request Status with message and boolean success details
	
	@tag7
	Scenario: Verify if Authorised  admin is able to update role id of a Admin with invalid Admin id
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS Put Request with endpoint
	Then Admin receives 400 Bad Request Status with message and boolean success details

	@tag8
	Scenario: Verify if Authorised admin is able to update a Admin with Admin Role Id with already existing Admin role ID
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS Put Request with endpoint
	Then Admin receives 400 Bad Request Status with message and boolean success details
	
	@tag9
	Scenario: Verify if Authorised admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS put Request with invalid endpoint
	Then Admin receives 404 Not Found Status with message and boolean success details

	@tag10
	Scenario: Verify if Authorised admin is able to update role status of a Admin with valid Admin id
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS put Request with endpoint with userId
	Then Admin receives 200 Ok Status with response message       
	
		@tag11
	Scenario: Verify if Authorised admin is able to update role status of a Admin with Invalid Admin id
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS put Request with endpoint with Invalid userId
	Then Admin receives 404 Not Found Status with response message       
	
	@tag12 
	Scenario: Verify if Authorised admin is able to update admin roleId with valid Admin Id
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS put Request with endpoint and valid Admin Id
	Then Admin receives 200 Ok Status with response message       
	
	
	@tag13 
	Scenario: Verify if Authorised admin is able to update User Role Program Batch Status   -----//Check data values
	Given Admin creates PUT Request with valid request body
	When Admin sends HTTPS put Request with endpoint with userId to update role program batch
	Then Admin receives 200 Ok Status with response message 
		
	  @tag14
	  Scenario: Verify if Authorised admin is able to Delete User with UserId
	  Given Admin creates DELETE Request to delete Admin details
	  When Admin sends HTTPS request with endpoint to delete user with user Id
	  Then Admin receives 200 Ok Status with response message 
	  

