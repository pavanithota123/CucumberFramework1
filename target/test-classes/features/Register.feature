Feature: Register Functionality

Scenario: User creates an account with mandatory fields
Given user navigates to register pager
When user enters below fields
|firstName|pavani|
|lastName|thota|
|email|auto|
|telephone|56858585678|
|password|Shyam@123|
And user selects privacy policy 
And user clicks on continue button
Then user account should created successfully

Scenario: User creates an account with all fields
Given user navigates to register pager
When user enters below fields
|firstName|pavani|
|lastName|thota|
|email|auto|
|telephone|8568588590|
|password|Shyam@123|
And user selects yes for news letter
And user selects privacy policy 
And user clicks on continue button
Then user account should created successfully

Scenario: User creates a duplicate account
Given user navigates to register pager
When user enters below fields with duplicate mail
|firstName|pavani|
|lastName|thota|
|email|pavantita12@gmail.com|
|telephone|56858585678|
|password|Shyam@123|
And user selects privacy policy
And user clicks on continue button
Then user account should get proper error

Scenario: user creates an account without filling any fields
Given user navigates to register pager
When user not entered any fields
And user clicks on continue button
Then user should get proper warning messages for every mandatory fields
