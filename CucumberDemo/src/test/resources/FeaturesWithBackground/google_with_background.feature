Feature: validate Google links

  Background: 
    Given Google page is open

  Scenario: validate Advertising link
    When Advertising link is clicked
    Then It should navigate to Google Ads page

  Scenario: validate Business link
    When Business link is clicked
    Then It should navigate to Google Business page

  Scenario: validate About link
    When About link is clicked
    Then It should navigate to About Google  page
