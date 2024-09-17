Feature: Login functionality

    @TC1
    Scenario: Login successfully
        Given open browser
        When enter username
        And enter passpord
        And click login
        Then verify login success
