Narrative:
As a user
I want to go onto seleniumeasy website
So that I can test some pages

Scenario: Form submitted message
Given user is on AjaxFormSubmitPage
When user writes some name
And user writes some comment
And user clicks submit button
And user waits until the message arrives
Then form should be submitted successfully