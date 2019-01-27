Narrative:
As a user
I want to go onto seleniumeasy website
So that I can test some pages

Scenario: Input message
Given user is on BasicFirstFormDemoPage
When user writes something
And user clicks Show Message button
Then result should be same as user phrase

Scenario: Adding two values
Given user is on BasicFirstFormDemoPage
When user enters value a and value b
And user clicks Get Total button
Then result should be the sum of two entered values