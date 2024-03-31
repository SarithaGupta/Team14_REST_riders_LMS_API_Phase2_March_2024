Feature: GET REQUEST (All programs)

Background: Admin sets Authorization 

Scenario: Check if Admin able to retrieve all programs with valid Endpoint
Given Admin creates GET Request for the LMS API
When Admin sends HTTPS Request with endpoint
Then Admin receives 200 OK Status with response body.  

                                                      
