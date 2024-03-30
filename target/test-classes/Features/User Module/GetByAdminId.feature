Feature: Get request by AdminId

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
#Given Admin creates GET Request with valid AdminId nad no auth
#When Admin sends HTTPS Request with valid endpoint
#Then Admin receives 401 OK Status with response body
#
