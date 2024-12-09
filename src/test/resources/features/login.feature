
Feature: Login functionality

    Scenario: Login Successfully
        Given the user is on the homepage
        When user enters email
        And user enters password
        And user submit login
        Then verify login successfully

    @Ignore
    Scenario: Login Failed
        Given the user is on the homepage
        When user enters email
        And user enters password
        Then verify login successfully
