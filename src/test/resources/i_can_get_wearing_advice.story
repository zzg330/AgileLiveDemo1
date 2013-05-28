Wearing Advice

Narrative: 

In order to be prepared for going outside
As a user
I want to get wearing advice based on weather forecast

            60-69       70-79               
Sunny       Shirts      T-shirt             
Raining     Raincoat    Umbrella, T-shirt     

Scenario: Get Wearing Advice by zip-code

Given I am on the weather page
When I type in a zipcode 70112
When I click the get button
Then Wearing advice should be displayed
