Feature: Login functionality cucumber

  Scenario Outline: Login case
    Given the user is on the homepage
    When user enters email
    And user enters password
    And user submit login
    Then verify login successfully

    Examples: Page titles
      | email                   | pass         | expected |
      | trongtuyen451@gmail.com | Admin@123456 | true     |
      | trongtuyentestfailse    | Admin@123456 | false    |
      | trongtuyen451@gmail.com | passerror    | false    |
      |                         | Admin@123456 | false    |
      | trongtuyen451@gmail.com |              | false    |
      |                         |              | false    |
    # @Ignore
    # Scenario: Login Failed
    #     Given the user is on the homepage
    #     When user enters email
    #     And user enters password
    #     Then verify login successfully
