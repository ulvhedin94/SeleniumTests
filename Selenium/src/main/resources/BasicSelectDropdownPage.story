Narrative:
As a user
I want to go onto seleniumeasy website
So that I can test some pages

Scenario: Select message
Given user is on BasicSelectDropdownDemoPage
When user clicks on the list
And user selects a value
Then result should be the same as user's choice

Scenario: Select many values
Given user is on BasicSelectDropdownDemoPage
When user clicks on the option
And user clicks on the First Selected button
Then result should be the same as user's chosen option