Feature: Booking functionality

    @TC1
    Scenario: Booking successfully
        Given open browser
        When enter username
        And enter passpord
        And click login
        Then verify login success
        When enter product
        And select option
        Then verify booking success 
