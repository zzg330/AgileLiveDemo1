Query Weather

Narrative: 

In order to get wheather information
As a user
I want to be able to get weather information with a zip-code

Scenario: Query weather by zip-code

Given I am on the weather page
When I type in a zipcode 70112
When I click the get button
Then City should be displayed as New Orleans
Then Region should be displayed as LA
Then Country should be displayed as US
Then Temperature should be displayed
Then Condition should be displayed
Then Humidity should be displayed
Then Wind Speed should be displayed