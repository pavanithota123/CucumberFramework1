Feature: Login Functionality

Scenario: login with valid credentials
Given when user navigate to login page
When user enters valid email "pavanithota916@gmail.com"
And user enters valid password "Shyam@143"
And user has to click on login button 
Then user should get successfully loggedin

Scenario: login with invalid credentials
Given when user navigate to login page
When user enters invalid email address into mail address
And user enters invalid password "shya" in password field 
And user has to click on login button
Then user should get proper warning message about credentials

Scenario: login with valid email and invalid password 
Given when user navigate to login page
When user enters valid email "pavanithota916@gmail.com"
And user enters invalid password "shya" in password field
And user has to click on login button
Then user should get proper warning message about credentials

Scenario: login with invalid email and valid password 
Given when user navigate to login page
When user enters invalid email address into mail address 
And user enters valid password "Shyam@143"
And user has to click on login button
Then user should get proper warning message about credentials
@smoke
Scenario: login without providing any credentials
Given when user navigate to login page
When user dont enter any email address
And user dont enter any password
And user has to click on login button
Then user should get proper warning message about credentials
